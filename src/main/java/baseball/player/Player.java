package baseball.player;

import baseball.data.BaseballNumbers;
import baseball.data.GameResult;

import java.util.List;

public interface Player {
    BaseballNumbers generateBallNumber(List<Integer> numbers) throws IllegalArgumentException;
    BaseballNumbers ask();
    GameResult reply(BaseballNumbers baseBallNumbers);
}
