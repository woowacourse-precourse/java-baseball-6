package baseball.game.umpire;

import baseball.game.CheckingBoard;
import baseball.game.Score;

public interface Umpire {
    CheckingBoard checkStrike(String ball, String bat, CheckingBoard checkingBoard);
    CheckingBoard checkBall(String ball, String bat, CheckingBoard checkingBoard);
    Score judge(CheckingBoard checkingBoard, Score score);
}
