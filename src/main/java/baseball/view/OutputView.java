package baseball.view;

import baseball.constant.OutputMessage;
import baseball.model.dto.BaseballGameResult;

public class OutputView {

    private final OutputConverter outputConverter;

    public OutputView() {
        this.outputConverter = new OutputConverter();
    }
    public void showResult(BaseballGameResult baseballGameResult) {
        String resultMessage = outputConverter.convertMessage(baseballGameResult);
        System.out.println(resultMessage);
    }

    public void printStartGame() {
        System.out.println(OutputMessage.START_GAME);
    }

    public void printInputNumber() {
        System.out.print(OutputMessage.PLEASE_INPUT_NUMBER);
    }

    public void printRestart() {
        System.out.println(OutputMessage.RESTART_GAME);
    }
}
