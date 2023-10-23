package baseball.exception;

public class GameStopExeception extends RuntimeException{
    public GameStopExeception(String message){
        super(message);
    }
}
