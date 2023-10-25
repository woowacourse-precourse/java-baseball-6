package baseball.phase;

import baseball.game.BaseballGame;
import baseball.phase.impl.GuessPhase;
import baseball.phase.impl.MenuPhase;

// Game 객체 내부에서 모든 구체적인 Phase를 생성하는 로직을 빼기 위해 enum에 값을 할당함
public enum PhaseID {
    GUESS(0, new GuessPhase()),
    MENU(1, new MenuPhase()),
    FINISH(2, null);
    private final int id;
    private final Phase phase;

    private PhaseID(int id, Phase phase) {
        this.id = id;
        this.phase = phase;
    }

    public int getId() {
        return id;
    }

    public Phase getPhase(BaseballGame game) {
        this.phase.setGame(game);
        return this.phase;
    }
}
