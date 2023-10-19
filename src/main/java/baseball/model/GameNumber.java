package baseball.model;

public class GameNumber {

    private static final String CONTINUE_NUMBER = "1";
    private static final String END_NUMBER = "2";

    private String gameNumber;

    private GameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static GameNumber createDefault() {
        return new GameNumber(CONTINUE_NUMBER);
    }

    public boolean canContinueGame() {
        if (gameNumber.equals(CONTINUE_NUMBER)) {
            return true;
        }
        return false;
    }

    public void changeNumber(final String number) {
        gameNumber = number;
    }
}
