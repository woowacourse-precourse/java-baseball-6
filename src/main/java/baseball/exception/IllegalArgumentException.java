package baseball.exception;

public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(){
        super();
    }
    public IllegalArgumentException(String message){
        super(message);
    }
}
