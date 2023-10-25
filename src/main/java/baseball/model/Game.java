package baseball.model;

public class Game {
    private int ballCount;
    private int strikeCount;
    private boolean enableGameOn;
    private boolean enableRestartGame;


    public Game() {
        this.enableGameOn = true;
        this.enableRestartGame = false;
    }

    public boolean isSuccess() {
        return strikeCount == 3;
    }

    public int getBallCount() {
        return ballCount;
    }
    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount (int strikeCount){
        this.strikeCount = strikeCount;
    }

    public void addstrikeCount() {
        this.strikeCount++;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public boolean isGameOn() {
        return enableGameOn;
    }

    public boolean isGameRestart() {
        return enableRestartGame;
    }

    public void controlGameMenu(String menuNumber) {

        String regex = "[1-2]{1}";
        boolean isInvalidDigit = !menuNumber.matches(regex);

        if (isInvalidDigit){
            throw new IllegalArgumentException();
        }

        if(menuNumber.equals("2")) {
            this.enableGameOn = false;
        } else {
            this.enableRestartGame = true;
        }
    }
}
