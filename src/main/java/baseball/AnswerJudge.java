package baseball;

import java.util.List;

public class AnswerJudge {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static String judge(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(computerNumber.get(i))) {
                strike++;
            } else if (userNumber.contains(computerNumber.get(i))) {
                ball++;
            }
        }
        return getResult(strike, ball);
    }

    private static String getResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        }
        if (strike == 3) {
            return getResultMessage(strike, ball) + WIN_MESSAGE;
        }
        return getResultMessage(strike, ball);
    }

    private static String getResultMessage(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append(BALL_MESSAGE).append(" ");
        }
        if (strike > 0) {
            result.append(strike).append(STRIKE_MESSAGE);
        }
        return result.toString();
    }

    public static boolean isWin(String result) {
        return result.contains(WIN_MESSAGE);
    }
}
