package baseball.game.umpire;

import baseball.game.Score;

public class ComputerUmpireImpl implements Umpire {
    @Override
    public Score checkStrike(int ball, int bat, Score score) {
        return null;
    }

    @Override
    public Score checkBall(int ball, int bat, Score score) {
        return null;
    }

    @Override
    public boolean judge(Score score) {
        return false;
    }
}
