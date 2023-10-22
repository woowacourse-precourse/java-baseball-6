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

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setGameWin(boolean gameWin) {
        this.gameWin = gameWin;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isGameWin() {
        return gameWin;
    }
}
