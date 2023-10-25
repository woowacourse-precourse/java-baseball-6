package baseball.model;

import java.util.List;

public class Model {
    private int[] input_number;
    private List<Integer> computer_number;
    private int strike_count;
    private int ball_count;

    public int[] getInput_number() {
        return input_number;
    }

    public void setInput_number(int[] input_number) {
        this.input_number = input_number;
        this.strike_count = 0;
        this.ball_count = 0;
    }

    public List<Integer> getComputer_number() {
        return computer_number;
    }

    public void setComputer_number(List<Integer> computer_number) {
        this.computer_number = computer_number;
    }

    public int getStrike_count() {
        return strike_count;
    }

    public int getBall_count() {
        return ball_count;
    }

    public void updateBallCount() {
        this.ball_count += 1;
    }

    public void updateStrikeCount() {
        this.strike_count += 1;
    }
}
