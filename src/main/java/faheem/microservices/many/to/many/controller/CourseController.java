package faheem.microservices.many.to.many.controller;


import faheem.microservices.many.to.many.entity.Course;
import faheem.microservices.many.to.many.entity.Student;
import faheem.microservices.many.to.many.exception.CourseNotFoundException;
import faheem.microservices.many.to.many.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course)  {
        log.info("CourseController.addCourse() method is called...");
        return courseService.addCourse(course);
    }

    @PostMapping("/addCourseWithStudent")
    public Course addCourseWithStudent(@RequestBody Course course){
        log.info("CourseController.addCourseWithStudent() method is called...");
        return courseService.addCourseWithStudent(course);
    }

    @PostMapping("/addNewStudentToExistingCourse")
    public Course addNewStudentToExistingCourse(@PathParam("courseId") int courseId, @RequestBody Student student) throws CourseNotFoundException {
        log.info("CourseController.addNewStudentToExistingCourse() method called....");
       return courseService.addNewStudentToExistingCourse(courseId,student);
    }


    @GetMapping("/getCourse")
    public Course getCourseById(@PathParam("courseId") int courseId) throws CourseNotFoundException {
        log.info("CourseController.getCourseById() method called....");
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getAllStudentsRegisteredInCourse")
    public List<Student> getAllStudentsRegisteredInCourse(int courseId) throws CourseNotFoundException {
        log.info("CourseController.getAllStudentsRegisteredInCourse() method called....");
        return courseService.getAllStudentsRegisteredInCourse(courseId);
    }
}
