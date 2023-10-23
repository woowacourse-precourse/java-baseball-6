package baseball.controller;

import static baseball.model.Message.START;

import baseball.model.DecimalNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private DecimalNumber decimalNumber = new DecimalNumber();
    private ComputerController computerController = new ComputerController();

    public void run() {
        Boolean isSuccess = true;

        //게임 재시작 여부 판단
        while (isSuccess) {
            outputView.printGame(START.getMessage());
            computerController.initComputer(decimalNumber);

            //메서드 분리 필요
            String inputNumber = inputView.inputGameIng();
            decimalNumber.setUser(inputNumber);

            //종료 코드 필요
        }
    }

}
