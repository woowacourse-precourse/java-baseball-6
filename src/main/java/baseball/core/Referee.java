package baseball.core;

import baseball.Enum.PointStatus;
import baseball.Enum.GameStatus;
import baseball.core.rule.PickedNumbers;
import baseball.core.rule.Rule;
import baseball.core.rule.ScoreResult;
import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final Rule rule;
    private GameStatus gameStatus;

    public void checkPoint(PickedNumbers pickedNumbers) {
        this.gameStatus = GameStatus.IN_PROGRESS;
        ScoreResult scoreResult = rule.calculatePoints(pickedNumbers);

        if (scoreResult.isNothing()) {
            System.out.println(PointStatus.NOTHING.getDescription());
            return;
        }

        if (scoreResult.getStrikeCount() == 3) {
            this.gameStatus = GameStatus.WIN;
            System.out.println(scoreResult.getStrikeCount() + PointStatus.STRIKE.getDescription());
            return;
        }

        List<String> results = new ArrayList<>();
        if (scoreResult.getBallCount() > 0) {
            this.gameStatus = GameStatus.IN_PROGRESS;
            results.add(String.format("%d%s", scoreResult.getBallCount(),
                PointStatus.BALL.getDescription()));
        }
        if (scoreResult.getStrikeCount() > 0) {
            this.gameStatus = GameStatus.IN_PROGRESS;
            results.add(String.format("%d%s", scoreResult.getStrikeCount(),
                PointStatus.STRIKE.getDescription()));
        }

        System.out.println(String.join(" ", results));
    }

    public Referee(Rule rule) {
        this.rule = rule;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
