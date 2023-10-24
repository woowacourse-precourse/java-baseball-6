package baseball.game;

import baseball.dto.GameRequest;
import baseball.dto.GameResponse;

public class GameDispatcherImpl implements GameDispatcher {

    private GamePlay gamePlay;

    public GameDispatcherImpl(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    @Override
    public GameResponse dispatch(GameRequest request) {

        try {
            String result = gamePlay.play(request.args());
            return new GameResponse("SUCCESS", result);

        } catch (IllegalArgumentException e) {
            return new GameResponse("FAIL", e.getMessage());
        }
    }
}
