package baseball.error;
public class CheckerForUnvalidRangeOfSelection {
    private final Integer MIN_SELECTABLE_NUMBER=2;
    public void check(String gameContinueSelection) {
        if (MIN_SELECTABLE_NUMBER < Integer.parseInt(gameContinueSelection)){
            throw new IllegalArgumentException();
        }
    }
}
