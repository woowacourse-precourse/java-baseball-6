package baseball.error;

public class CheckerForUnvalidLengthOfSelection {
    private final Integer MAX_LENGTH_OF_SELECTION = 1;
    public void check(String gameContinueSelection) {
        if (gameContinueSelection.length() != MAX_LENGTH_OF_SELECTION){
            throw new IllegalArgumentException();
        }
    }
}
