package baseball.print;

import baseball.check.Hint;

import java.util.List;

public interface PrintService {

    void gameStartMessage();

    void inputMessage();

    void gameEndMessage();

    void restartMessage();

    void resultMessage(int strikeCount, int ballCount);

}
