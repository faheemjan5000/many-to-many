package faheem.microservices.many.to.many;


import faheem.microservices.many.to.many.entity.Course;
import faheem.microservices.many.to.many.entity.Student;
import faheem.microservices.many.to.many.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void addCourse(){
        log.info("CourseRepositoryTest.addCourse() method called....");
        Course course = Course.builder()
        .credit(12)
        .title("Algorithm")
        .build();
        courseRepository.save(course);
        log.info("course added successfully");
    }

    @Test
    public void addCourseWithStudent(){
        Student student = Student.builder()
                .firstName("luca")
                .lastName("champ")
                .build();

        log.info("CourseRepositoryTest.addCourse() method called....");
        Course course = Course.builder()
                .credit(10)
                .title("physics")
                .build();
        course.addStudent(student);
        courseRepository.save(course);
    }

    @Test
    public void addNewCourseWithNewStudents(){
        log.info("CourseRepositoryTest.addNewCourseWithNewStudents() method called....");
        Student fransca = Student.builder()
                .firstName("fransca")
                .lastName("marra")
                .build();
        Student monica = Student.builder()
                .firstName("monica")
                .lastName("longo")
                .build();

        Course course = Course.builder()
                .credit(10)
                .title("chemistry")
                .build();
        course.addStudent(fransca);
        course.addStudent(monica);
        courseRepository.save(course);
    }

    @Test
    public void addNewStudentToExistingCourse(){
        Student melissa = Student.builder()
                .firstName("melissa")
                .lastName("latella")
                .build();
        int courId = 2;
        if(courseRepository.findById(2).isPresent()) {
            log.info("course found");
            Course course = courseRepository.findById(2).get();
            course.addStudent(melissa);
            courseRepository.save(course);
            log.info("course added");
        }
        else{
            log.info("course with id not found : {}",courId);
        }
    }

    @Test
    public void getCourseById(){
        int courseId = 5;
        if(courseRepository.findById(2).isPresent()) {
            log.info("course found");
            Course course = courseRepository.findById(courseId).get();
            if(course.getStudents().size()!=0){
                log.info("Total students in this course : {}",course.getStudents().size());
                log.info("this course is taken by the following students");
                for(Student student : course.getStudents()){
                    log.info("student : {}",student.getFirstName());
                }
            }
            else{
                log.info("this course has no students");
            }
        }
        else{
            log.info("course with id not found : {}",courseId);
        }

    }
}
