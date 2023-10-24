package baseball.model;

public class EndGame {
    public static final String RESTART = "1";
    public static final String END = "2";
    private String lastNum;

    public EndGame(String lastNum) {
        lastNumCheck(lastNum);
        this.lastNum = lastNum;
    }

    public boolean isLast() {
        return this.lastNum.equals(RESTART);
    }

    private void lastNumCheck(String lastNum) {
        if (!lastNum.equals(RESTART) && !lastNum.equals(END)) {
            throw new IllegalArgumentException();
        }
    }
}