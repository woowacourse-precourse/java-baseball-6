package baseball.game.repository;

import static baseball.game.entity.NumberBaseBallGameWord.BALL;
import static baseball.game.entity.NumberBaseBallGameWord.NOTHING;
import static baseball.game.entity.NumberBaseBallGameWord.STRIKE;

import baseball.game.NumberBaseBallGameMessage;
import baseball.game.entity.GameScore;
import java.util.HashMap;
import java.util.Map;

public class GameResultRepository {
    private static Map<GameScore, String> gameResultMap = new HashMap<>();
    private static GameResultRepository instance;

    private GameResultRepository() {
    }

    public static GameResultRepository getInstance() {
        if (instance == null) {
            instance = new GameResultRepository();
            instance.init();

            return instance;
        }
        return instance;
    }

    private void init() {
        gameResultMap.put(new GameScore(0, 0), NOTHING.getMessage());
        gameResultMap.put(new GameScore(0, 1), 1 + BALL.getMessage());
        gameResultMap.put(new GameScore(0, 2), 2 + BALL.getMessage());
        gameResultMap.put(new GameScore(0, 3), 3 + BALL.getMessage());
        gameResultMap.put(new GameScore(1, 0), 1 + STRIKE.getMessage());
        gameResultMap.put(new GameScore(2, 0), 2 + STRIKE.getMessage());
        gameResultMap.put(new GameScore(1, 1), 1 + BALL.getMessage() + " " + 1 + STRIKE.getMessage());
        gameResultMap.put(new GameScore(1, 2), 2 + BALL.getMessage() + " " + 1 + STRIKE.getMessage());
        gameResultMap.put(new GameScore(3, 0), NumberBaseBallGameMessage.getEndMessage());
    }

    public String getGameResultMessage(GameScore gameScore) {
        return gameResultMap.get(gameScore);
    }
}
