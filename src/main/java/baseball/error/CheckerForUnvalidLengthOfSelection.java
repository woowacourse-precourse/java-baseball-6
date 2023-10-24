package baseball.error;

public class CheckerForUnvalidLengthOfSelection {
    public void check(String gameContinueSelection) {
        if (gameContinueSelection.length() != 1){
            throw new IllegalArgumentException();
        }
    }
}
