package baseball.view;

import baseball.constant.OutputMessage;
import baseball.domain.GameResult;

public class OutputView {

    public void printStartMessage() {
        System.out.println(OutputMessage.GAME_START.getMessage());
    }

    public void printInputGuide() {
        System.out.print(OutputMessage.PLAYER_INPUT_GUIDE.getMessage());
    }

    public void printGameResult(GameResult result) {
        System.out.println(result.getResultScreen());
    }
}
