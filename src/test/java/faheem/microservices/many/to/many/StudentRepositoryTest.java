package faheem.microservices.many.to.many;


import faheem.microservices.many.to.many.entity.Student;
import faheem.microservices.many.to.many.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        log.info("StudentRepositoryTest.saveStudent() method called...");
        Student student = Student.builder()
                .firstName("faheem")
                .lastName("jan")
                .build();
        studentRepository.save(student);
        log.info("student added successfully");
    }
}
