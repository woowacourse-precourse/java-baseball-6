package baseball.controller;

import baseball.model.NumberBaseball;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class NumberBaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberBaseballService numberBaseballService;

    public NumberBaseballController(InputView inputView, OutputView outputView, NumberBaseballService numberBaseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberBaseballService = numberBaseballService;
    }

    public void run() {
        inputView.showGameStartMent();
        readInputNumFromInputView();
    }

    public void readInputNumFromInputView() {
        List<Integer> inputNumList = inputView.readNum();
        compareInputNumToRandNum(inputNumList);
    }

    public void compareInputNumToRandNum(List<Integer> inputNumList) {
        numberBaseballService.compareInputNumToRandNum(inputNumList);

        // 결과를 outputView로 전달
    }


}
