package baseball.phase.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;

public class MenuPhase implements Phase {
    private BaseballGame baseballGame;

    public MenuPhase(BaseballGame game) {
        this.baseballGame = game;
    }


    @Override
    public void display() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void validateInput(String input) {
        if (input.length() >= 2) {
            throw new IllegalArgumentException();
        }
        char ch = input.charAt(0);
        if ('1' > ch || ch > '2') {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public PhaseID action(String input) {
        char ch = input.charAt(0);
        if (ch == '1') {
            this.baseballGame.getEvaluator().resetAnswer();
            return PhaseID.GUESS;
        } else {
            return PhaseID.FINISH;
        }
    }
}
