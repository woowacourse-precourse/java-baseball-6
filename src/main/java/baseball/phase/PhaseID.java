package baseball.phase;

import baseball.game.BaseballGame;
import baseball.phase.impl.GuessPhase;
import baseball.phase.impl.MenuPhase;

// Game 객체 내부에서 모든 구체적인 Phase를 생성하는 로직을 빼기 위해 enum에 값을 할당함
public enum PhaseID {
    GUESS(0) {
        @Override
        public Phase createPhase(BaseballGame game) {
            return new GuessPhase(game);
        }
    },
    MENU(1) {
        @Override
        public Phase createPhase(BaseballGame game) {
            return new MenuPhase(game);
        }
    },
    FINISH(2) {
        @Override
        public Phase createPhase(BaseballGame game) {
            return null;
        }
    };
    private final int id;

    private PhaseID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract Phase createPhase(BaseballGame game);
}
