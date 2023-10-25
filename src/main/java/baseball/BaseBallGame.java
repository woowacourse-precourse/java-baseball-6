package baseball;


import static baseball.BaseBallConst.BALL;
import static baseball.BaseBallConst.GAME_FINISH;
import static baseball.BaseBallConst.GAME_START;
import static baseball.BaseBallConst.NUM_SIZE;
import static baseball.BaseBallConst.OP_RESTART;
import static baseball.BaseBallConst.READ_NUMS;
import static baseball.BaseBallConst.RESTART_QUESTION;
import static baseball.BaseBallConst.STRIKE;
import static baseball.BaseBallConst.STRING_BALL;
import static baseball.BaseBallConst.STRING_NOT_THING;
import static baseball.BaseBallConst.STRING_STRIKE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    Computer computer;

    public BaseBallGame() {
        this.computer = new Computer();
    }

    public void start() {
        System.out.println(GAME_START);
        boolean restart = true;
        while (restart) {
            computer.generateNums();
            playBall();
            restart = readRestartOption();
        }
    }

    public void playBall() {
        boolean playing = true;
        while (playing) {
            List<Integer> result = computer.checkNums(readNums());
            playing = checkResult(result);
        }
    }

    public boolean readRestartOption() {
        System.out.println(RESTART_QUESTION);
        String input = readLine();
        if (input.length() != 1 || !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input) == OP_RESTART;
    }

    public List<Integer> readNums() {
        System.out.print(READ_NUMS);
        String input = readLine();
        List<Integer> nums = new ArrayList<>();
        if (input.length() != NUM_SIZE) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < NUM_SIZE; i++) {
            nums.add(input.charAt(i) - '0');
        }
        return nums;
    }

    public Boolean checkResult(List<Integer> result) {
        int strike = result.get(STRIKE);
        int ball = result.get(BALL);
        StringBuilder sb = new StringBuilder();
        if (ball + strike == 0) {
            sb.append(STRING_NOT_THING);
        } else {
            if (ball > 0) {
                sb.append(ball).append(STRING_BALL).append(" ");
            }
            if (strike > 0) {
                sb.append(strike).append(STRING_STRIKE);
            }
        }
        System.out.println(sb);
        if (strike == NUM_SIZE) {
            System.out.println(GAME_FINISH);
            return false;
        }
        return true;
    }
}
