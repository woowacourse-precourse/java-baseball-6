package baseball;

import java.util.*;

public class GameLogic {
    public int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if (answer.get(idx).equals(input.get(idx))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if (!answer.get(idx).equals(input.get(idx)) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

    public String makeHint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike != 0) {
            if (ball != 0) {
                sb.append(ball).append("볼 ").append(strike).append("스트라이크");
                return sb.toString();
            }
            sb.append(strike).append("스트라이크");
            return sb.toString();
        }
        if (ball != 0) {
            sb.append(ball).append("볼");
            return sb.toString();
        }
        sb.append("낫싱");
        return sb.toString();
    }
}
