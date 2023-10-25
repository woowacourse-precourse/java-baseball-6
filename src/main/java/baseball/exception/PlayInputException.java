package baseball.exception;

public class PlayInputException {
    private static final String RESTART_NUMBER = "1";
    private static final String GAME_OVER_NUMBER = "2";
    public boolean isValid(String input){
            return input.equals(RESTART_NUMBER) || input.equals(GAME_OVER_NUMBER);
        }
}
