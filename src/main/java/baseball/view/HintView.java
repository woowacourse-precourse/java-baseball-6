package baseball.view;

import baseball.model.Ball;
import baseball.model.Strike;
import java.util.ArrayList;
import java.util.List;

public class HintView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private final List<String> message = new ArrayList<>();

    public HintView(Ball ball, Strike strike) {
        addBallMessage(ball);
        addStrikeMessage(strike);
        addNothingMessage(ball, strike);
    }

    public void addBallMessage(Ball ball) {
        if (ball.count() != 0) {
            message.add(ball.count() + BALL);
        }
    }

    public void addStrikeMessage(Strike strike) {
        if (strike.count() != 0) {
            message.add(strike.count() + STRIKE);
        }
    }

    public void addNothingMessage(Ball ball, Strike strike) {
        if (strike.count() == 0 && ball.count() == 0) {
            message.add(NOTHING);
        }
    }

    public String getMessage() {
        return String.join(" ", message);
    }
}
