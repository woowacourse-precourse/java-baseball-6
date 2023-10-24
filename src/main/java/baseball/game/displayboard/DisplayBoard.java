package baseball.game.displayboard;

import baseball.game.Score;

public interface DisplayBoard {
    void displayGameStart();
    void displayRequestNum();
    void displayScore(Score score);
    void displayQuestionRestart();
}
