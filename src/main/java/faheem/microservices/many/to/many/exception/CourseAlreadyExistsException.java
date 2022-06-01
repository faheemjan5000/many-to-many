package faheem.microservices.many.to.many.exception;

public class CourseAlreadyExistsException extends Exception{

    public CourseAlreadyExistsException(String message){
        super(message);
    }

}
