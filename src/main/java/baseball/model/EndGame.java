package baseball.model;

public class EndGame {
    public static final String Restart = "1";
    public static final String End = "2";
    private String LastNum;
    public EndGame(String LastNum) {
        LastNumCheck(LastNum);
        this.LastNum = LastNum;
    }
    public boolean isLast() {
        return this.LastNum.equals(Restart);
    }
    private void LastNumCheck(String LastNum) {
        if (!LastNum.equals(Restart) && !LastNum.equals(End)) {
            throw new IllegalArgumentException();
        }
    }
}
