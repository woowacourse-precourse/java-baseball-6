package baseball;

import baseball.validation.NumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        NumberValidation validation = new NumberValidation();

        outputView.printStartMessage();
        outputView.printInputMessage();
        int userNum = inputView.enterNumber(validation);
    }
}
