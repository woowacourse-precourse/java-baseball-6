package baseball.entity;

public class Player {
    private String inputString;
    private int strikeCount=0;
    private int ballCount=0;
    private boolean gameWin = false;

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

}
