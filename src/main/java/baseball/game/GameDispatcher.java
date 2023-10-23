package baseball.game;

import baseball.dto.GameRequest;
import baseball.dto.GameResponse;

public interface GameDispatcher {
    GameResponse dispatch(GameRequest request);
}
