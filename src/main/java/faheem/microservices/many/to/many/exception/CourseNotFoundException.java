package faheem.microservices.many.to.many.exception;

public class CourseNotFoundException extends Exception{

    public CourseNotFoundException(String message){
        super(message);
    }
}
