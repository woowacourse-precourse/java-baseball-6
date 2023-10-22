package baseball.view;

import baseball.dto.GameResult;

public class OutputView {

    public void writeInlineMessage(String message) {
        System.out.print(message);
    }

    public void writeNewlineMessage(String message) {
        System.out.println(message);
    }

    public void writeNewlineMessage(GameResult gameResult) {
        System.out.println(gameResult);
    }
}
