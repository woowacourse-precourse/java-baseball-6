package baseball.game.umpire;

import baseball.game.CheckingBoard;
import baseball.game.Score;

public interface Umpire {
    Boolean[] checkStrike(String ball, String bat, Boolean[] strikeCheckingBoard);
    Boolean[] checkBall(String ball, String bat, Boolean[] strikeCheckingBoard, Boolean[] ballCheckingBoard);
    Score judge(CheckingBoard checkingBoard, Score score);
}
