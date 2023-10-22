package baseball.dto;

public class Player {
    private String input = "";
    private int[] playerNumberBall;
    private String condition = "";

    public Player() {
    }

    public Player(String input, int[] playerNumberBall, String condition) {
        this.input = input;
        this.playerNumberBall = playerNumberBall;
        this.condition = condition;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int[] getPlayerNumberBall() {
        return playerNumberBall;
    }

    public void setPlayerNumberBall(int[] playerNumberBall) {
        this.playerNumberBall = playerNumberBall;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
