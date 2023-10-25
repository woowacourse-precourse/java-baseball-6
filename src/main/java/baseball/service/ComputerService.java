package baseball.service;

import java.util.List;

public class ComputerService {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static int countStrike(List<Integer> playerInput, List<Integer> computerAnswer) {
        int strike = 0;
        for (int i = 0; i < computerAnswer.size(); i++) {
            int cur = playerInput.get(i);
            if (computerAnswer.contains(cur) && computerAnswer.indexOf(cur) == i) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBall(List<Integer> playerInput, List<Integer> computerAnswer) {
        int ball = 0;
        for (int i = 0; i < computerAnswer.size(); i++) {
            int cur = playerInput.get(i);
            if (computerAnswer.contains(cur) && computerAnswer.indexOf(cur) != i) {
                ball++;
            }
        }
        return ball;
    }

    public static String getResultMessage(int ball, int strike) {
        String ballMessage = getBallMessage(ball);
        String strikeMessage = getStrikeMessage(strike);
        if (ballMessage.isEmpty() && strikeMessage.isEmpty()) {
            return NOTHING;
        }
        if (strikeMessage.isEmpty()) {
            return ballMessage;
        }
        if (ballMessage.isEmpty()) {
            return strikeMessage;
        }
        return ballMessage + " " + strikeMessage;
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return "";
        }
        return ball + BALL;
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return "";
        }
        return strike + STRIKE;
    }
}
