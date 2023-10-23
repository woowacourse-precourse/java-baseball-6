package baseball.view;

import baseball.model.GameResult;
import java.util.ArrayList;
import java.util.List;

public class HintView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private final List<String> message = new ArrayList<>();

    public HintView(GameResult result) {
        addBallMessage(result.ball());
        addStrikeMessage(result.strike());
        addNothingMessage(result.ball(), result.strike());
    }

    public void addBallMessage(int ball) {
        if (ball != 0) {
            message.add(ball + BALL);
        }
    }

    public void addStrikeMessage(int strike) {
        if (strike != 0) {
            message.add(strike + STRIKE);
        }
    }

    public void addNothingMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            message.add(NOTHING);
        }
    }

    public void printHint() {
        System.out.println(String.join(" ", message));
    }
}
