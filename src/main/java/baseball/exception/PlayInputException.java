package baseball.exception;

public class PlayInputException {
    private static final String reStartNum = "1";
    private static final String gameOverNum = "2";


    public boolean isValid(String input){
            return input.equals(reStartNum) || input.equals(gameOverNum);
        }

}
