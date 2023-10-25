package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    private final Map<Integer, Integer> answer;
    private final int NUM_SIZE = 3;

    public Computer() {
        answer = createRandomNumber();
    }

    private Map<Integer, Integer> createRandomNumber() {
        Map<Integer, Integer> result = new HashMap<>();

        int idx = 0;
        while (result.size() < NUM_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!result.containsKey(num)) {
                result.put(num, idx++);
            }
        }
        return result;
    }

    public boolean isCorrect(String playerNum) {
        int[] result = checkNum(playerNum);
        if (result[1] == 3) {
            return true;
        }
        printResult(result[0], result[1]);
        return false;
    }

    /**
     * @param playerNum
     * @return new int[2]{ ball개수, strike개수 }
     */
    private int[] checkNum(String playerNum) {
        int ball = 0, strike = 0;

        for (int i = 0; i < NUM_SIZE; i++) {
            int num = playerNum.charAt(i) - '0';
            if (answer.containsKey(num)) {
                if (answer.get(num) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return new int[]{ball, strike};
    }

    private void printResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball + "볼");
        }
        if (strike > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }
}
