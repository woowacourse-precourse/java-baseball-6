package baseball.domain.player;

import baseball.domain.game.ContinueAnswer;

public interface BaseballPlayer {
        String submitThreeNumber(int limitLength);
        ContinueAnswer responseContinuePlay();
}
