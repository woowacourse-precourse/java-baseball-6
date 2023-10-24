package baseball.exception;

public class GameStopExeception extends IllegalArgumentException{
    public GameStopExeception(String message){
        super(message);
    }
}
