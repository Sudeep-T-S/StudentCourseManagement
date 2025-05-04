package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService implements IEnrollmentService {
    private final IRepository<Student, Long> studentRepository;
    private final IRepository<Course, Long> courseRepository;
    private final IValidator<EnrollmentData> enrollmentValidator;
    private final ILogger logger;
    private final IAuditService auditService;
    private final INotificationService notificationService;

    
    public EnrollmentService(IStudentService studentService, ICourseService courseService, ILogger logger, IAuditService auditService, INotificationService notificationService) {
        this.studentRepository = ((StudentService) studentService).getStudentRepository();
        this.courseRepository = ((CourseService) courseService).getCourseRepository();
        this.enrollmentValidator = new EnrollmentValidator();
        this.logger = logger;
        this.auditService = auditService;
        this.notificationService = notificationService;
    }

    @Override
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        enrollmentValidator.validate(new EnrollmentData(student, course));

        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
            logger.log("Enrolled student " + studentId + " in course " + courseId);
            auditService.recordAudit("ENROLL", studentId, courseId);
            notificationService.sendNotification("Student " + studentId + " has been enrolled in course " + courseId);
        }
        if (!course.getStudents().contains(student)) {
            course.getStudents().add(student);
        }
    }

    @Override
    public void unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course not found");
        }

        student.getCourses().remove(course);
        course.getStudents().remove(student);
        logger.log("Unenrolled student " + studentId + " from course " + courseId);
        auditService.recordAudit("UNENROLL", studentId, courseId);
        notificationService.sendNotification("Student " + studentId + " has been unenrolled from course " + courseId);
    }

    @Override
    public List<Course> getCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return student.getCourses();
    }

    @Override
    public List<Student> getStudentsInCourse(Long courseId) {
        Course course = courseRepository.findById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found");
        }
        return course.getStudents();
    }
}