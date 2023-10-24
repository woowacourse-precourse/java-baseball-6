package baseball.game.gamesetter;

import baseball.game.CheckingBoard;
import baseball.game.Score;

public interface GameSetting {
    void startGame();
    void initGame(CheckingBoard checkingBoard, Score score);
    void progressGame();
    void questionRestartGame();
    void setGame();
}
