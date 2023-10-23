package baseball;

import static baseball.Enum.BALL;
import static baseball.Enum.CORRECT_AND_END_THE_GAME;
import static baseball.Enum.NOTHING;
import static baseball.Enum.STRIKE;

import java.util.List;


public class Hint {
    private List<Integer> computer;
    private String[] inputArr;

    public Hint(List<Integer> computer, String input) {
        this.computer = computer;
        this.inputArr = input.split("");
    }

    public int checkNumber() {
        StringBuilder sb = new StringBuilder();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            int num = Integer.parseInt(inputArr[i]);
            if (computer.get(i) == num) {
                strike += 1;
            } else if (computer.contains(num)) {
                ball += 1;
            }
        }
        if (strike == 3) {
            System.out.println(CORRECT_AND_END_THE_GAME.getMessage());
            return 1;
        }
        if (strike + ball == 0) {
            sb.append(NOTHING.getMessage());
        }
        if (ball != 0) {
            sb.append(ball).append(BALL.getMessage());
        }
        if (strike != 0) {
            if (ball != 0) {
                sb.append(" ");
            }
            sb.append(strike).append(STRIKE.getMessage());
        }
        System.out.println(sb);
        return -1;
    }
}
