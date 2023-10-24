package baseball;

public class BallStrike { // 볼, 스트라이크 판정

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    int ball;
    int strike;

    // 플레이어와 컴퓨터의 답안 비교
    void compareAnswer(Game answer, Game rightAnswer) {
        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            int nowNumber = answer.numberArr[i];

            if (!checkArrayContains(rightAnswer.numberArr, nowNumber)) {
                continue;
            }
            if (i == getIndexFromValue(rightAnswer.numberArr, nowNumber)) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    static boolean checkArrayContains(final int[] arr, final int number) {
        for (int val : arr) {
            if (val == number) {
                return true;
            }
        }
        return false;
    }

    static int getIndexFromValue(final int[] arr, final int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    void showResult() {
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(ball).append(BALL_MESSAGE);
        }
        if (strike != 0) {
            if (ball != 0) {
                result.append(" ");
            }
            result.append(strike).append(STRIKE_MESSAGE);
        }
        if (result.length() == 0) {
            result.append(NOTHING_MESSAGE);
        }
        System.out.println(result);
    }

}
