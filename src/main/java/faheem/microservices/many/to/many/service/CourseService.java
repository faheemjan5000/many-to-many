package faheem.microservices.many.to.many.service;


import faheem.microservices.many.to.many.entity.Course;
import faheem.microservices.many.to.many.entity.Student;
import faheem.microservices.many.to.many.exception.CourseNotFoundException;
import faheem.microservices.many.to.many.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course addCourse(Course course)  {
        log.info("CourseService.addCourse() method called....");
            return courseRepository.save(course);
    }

    public Course addCourseWithStudent(Course course){
        log.info("CourseService.addCourseWithStudent() method called....");
        return courseRepository.save(course);
    }

    public Course addNewStudentToExistingCourse(int courseId,Student student) throws CourseNotFoundException {
        if(courseRepository.findById(courseId).isPresent()) {
            log.info("course found");
            Course course = courseRepository.findById(courseId).get();
            course.addStudent(student);
            log.info("course added");
           return courseRepository.save(course);
        }
        else{
            log.error("course with id not found : {}",courseId);
            throw new CourseNotFoundException("course not found");
        }
    }

    public Course getCourseById(int courseId) throws CourseNotFoundException {
        log.info("CourseService.getCourseById() method called..");
        if(courseRepository.findById(courseId).isPresent()) {
            log.info("course found");
            Course courseFound = courseRepository.findById(courseId).get();
            return courseFound;
        }
        else{
            log.error("course with id not found : {}",courseId);
            throw new CourseNotFoundException("course not found");
        }
    }

    public List<Student> getAllStudentsRegisteredInCourse(int courseId) throws CourseNotFoundException {
        log.info("CourseService.getAllStudentsRegisteredInCourse() method called..");
        if(courseRepository.findById(courseId).isPresent()) {
            log.info("course found");
            return courseRepository.findById(courseId).get().getStudents();
        }
        else{
            log.error("course with id not found : {}",courseId);
            throw new CourseNotFoundException("course not found");
        }
    }
}
