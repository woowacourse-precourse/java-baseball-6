package baseball.dto;

public class Player {
    private String input = "";
    private int[] playerNumberBall;
    private String condition = "";

    Player() {
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
