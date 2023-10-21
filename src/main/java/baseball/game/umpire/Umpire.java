package baseball.game.umpire;

import baseball.game.Score;

public interface Umpire {
    Score checkStrike(int ball, int bat, Score score);
    Score checkBall(int ball, int bat, Score score);
    boolean judge(Score score);
}
