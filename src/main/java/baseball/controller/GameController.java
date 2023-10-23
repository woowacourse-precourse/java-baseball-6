package baseball.controller;

import static baseball.model.Message.INPUT;
import static baseball.model.Message.START;

import baseball.model.DecimalNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private DecimalNumber decimalNumber = new DecimalNumber();
    private Validation validation = new Validation();
    private ComputerController computerController = new ComputerController(outputView, validation);

    public void run() {
        Boolean isSuccess = true;

        //게임 재시작 여부 판단
        while (isSuccess) {
            outputView.printlnGame(START.getMessage());
            computerController.startGame(decimalNumber);

            //메서드 분리 필요
            outputView.printGame(INPUT.getMessage());
            String input = inputView.input();
            validation.validationGameNumber(input);
            decimalNumber.setUser(input);

            //종료 코드 필요
        }
    }
}
