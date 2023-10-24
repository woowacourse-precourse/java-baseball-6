package baseball.game.gamesetter;

import baseball.GameStatus;
import baseball.game.CheckingBoard;
import baseball.game.Score;

public interface GameSetting {
    void startGame();
    void initGame(CheckingBoard checkingBoard, Score score);
    void progressGame();
    GameStatus questionRestartGame(GameStatus gameStatus);
    void setGame();
}
