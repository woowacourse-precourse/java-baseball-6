package baseball;

import java.util.List;

public class GameResult {
    private List<Integer> computer;
    private List<Integer> player;
    private int strike;
    private int ball;


    public GameResult(List<Integer> computer, List<Integer> player) {
        calculate(computer, player);
    }

    public void calculate(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
        calculateBallCount();
        calculateStrikeCount();
    }

    private void calculateStrikeCount() {
        strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            }
        }
    }

    private void calculateBallCount() {
        ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) != player.get(i) && computer.contains(player.get(i))) {
                ball += 1;
            }
        }
    }

    public String toString() {
        String result = "";
        if (ball > 0) {
            result += ball + "볼" + " ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result += "낫싱";
        }
        return result;
    }

    public boolean isGameOver() {
        if (strike == computer.size()) {
            return true;
        }
        return false;
    }
}
