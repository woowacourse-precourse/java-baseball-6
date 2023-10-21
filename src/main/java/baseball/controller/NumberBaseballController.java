package baseball.controller;

import baseball.model.NumberBaseballResult;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballController {

    private static final int RE_GAME = 1;
    private static final int END_GAME = 2;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberBaseballService numberBaseballService;

    public NumberBaseballController(InputView inputView, OutputView outputView, NumberBaseballService numberBaseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberBaseballService = numberBaseballService;
    }

    public void run() throws IllegalArgumentException{
        inputView.showGameStartMent();
        readInputNumFromInputView();
    }

    public void readInputNumFromInputView() throws IllegalArgumentException{
        createGameResultFromInputNum(inputView.readNum());
    }

    private void sameCheckInputNumAndCompNum(int inputNum) {
        if(numberBaseballService.isSameNum(inputNum)) {
            processOfEndGame();
        }
    }

    public void createGameResultFromInputNum(int inputNum) throws IllegalArgumentException{
        sameCheckInputNumAndCompNum(inputNum);
        NumberBaseballResult gameResult = numberBaseballService.countStrikeAndBall(inputNum);
        sendGameResultToOutputView(gameResult);
    }

    private void loopGame() {
        readInputNumFromInputView();
    }

    private void generateNewGame() {
        numberBaseballService.newGame();
    }

    private void sendGameResultToOutputView(NumberBaseballResult numberBaseballResult) {
        outputView.printGameResult(numberBaseballResult);
        loopGame();
    }

    private void processOfEndGame() throws IllegalArgumentException {
        outputView.printEndGame();
        if(inputView.readNumOfReGame() == RE_GAME) {
            generateNewGame();
            readInputNumFromInputView();
            return;
        }

        outputView.endOfGame();
    }


}
