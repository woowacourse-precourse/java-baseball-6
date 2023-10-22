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

    public boolean checkNumber() {
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
            System.out.println(CORRECT_AND_END_THE_GAME);
            return true;
        } else if (strike + ball == 0) {
            sb.append(NOTHING);
        } else if (strike == 0) {
            sb.append(ball).append(BALL);
        } else if (ball == 0) {
            sb.append(strike).append(STRIKE);
        } else {
            sb.append(ball).append(BALL).append(" ").append(strike).append(STRIKE);
        }
        System.out.println(sb);
        return false;
    }
}
