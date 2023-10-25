package baseball.phase;

import baseball.game.BaseballGame;

public interface Phase {
    PhaseID nextPhase();

    void play();

    void setGame(BaseballGame game);
}
