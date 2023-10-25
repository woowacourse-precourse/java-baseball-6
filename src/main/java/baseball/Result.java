package baseball;

import java.util.List;

public class Result {
    public static boolean checkStrikeBallCount(List<Integer> random, List<Integer> input) {
        int strike = getStrikeCount(random, input);
        int ball = getBallCount(random, input);
        printResult(strike, ball);
        return isAnswer(strike);
    }

    public int getStrikeCount(List<Integer> random, List<Integer> input) {
        int strickeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (random.get(i) == input.get(i)) {
                strickeCount++;
            }
        }

        return strickeCount;
    }

    public int getBallCount(List<Integer> random, List<Integer> input) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            int num = random.get(i);
            if (input.contains(num) && input.get(i) != random.get(i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean isAnswer(int strike) {
        return strike == 3;
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }
    }
}
