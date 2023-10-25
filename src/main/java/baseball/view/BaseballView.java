package baseball.view;

import baseball.domain.BaseballResult;

public class BaseballView {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStartMessage() {
        outputView.gameStartMessage();
    }

    public String inputUserNumbersMessage() {
        outputView.inputUserNumbersMessage();
        return inputView.inputUserNumbers();
    }

    public void resultMessage(BaseballResult gameResult) {
        outputView.resultMessage(gameResult.getResultMessage());
    }

    public String inputUserCommandMessage() {
        outputView.completeMessage();
        return inputView.inputUserCommand();
    }
}
