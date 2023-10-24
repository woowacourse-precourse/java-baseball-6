package baseball;

import static baseball.Enum.BALL;
import static baseball.Enum.CORRECT_AND_END_THE_GAME;
import static baseball.Enum.NOTHING;
import static baseball.Enum.STRIKE;

import java.util.List;


public class Hint {
    public int checkNumber(List<Integer> computer, String input) {
        // 문자열 배열로 치환
        String[] inputArr = input.split("");
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
        // 정답
        if (strike == 3) {
            System.out.println(CORRECT_AND_END_THE_GAME.getMsg());
            return 1;
        }
        // 낫싱
        if (strike + ball == 0) {
            System.out.println(NOTHING.getMsg());
            return -1;
        }
        // 볼
        if (ball != 0) {
            sb.append(ball).append(BALL.getMsg());
        }
        // 스트라이크
        if (strike != 0) {
            if (ball != 0) { // 볼 & 스트라이크
                sb.append(" ");
            }
            sb.append(strike).append(STRIKE.getMsg());
        }
        System.out.println(sb);
        return -1;
    }
}
