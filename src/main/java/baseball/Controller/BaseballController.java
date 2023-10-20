package baseball.Controller;

import baseball.Service.BaseballService;
import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService;
    private InputView inputView;
    private OutputView outputView;

    public BaseballController() {
        baseballService = new BaseballService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void gameStart() {
        while (true) {
            outputView.printStartMessage();
            List<Character> randomNumber = getRandomNumberList();
            while (true) {
                boolean gameResult = baseballService.GameLogic(randomNumber, inputView.readInputNumber());
                if (!gameResult) {
                    continue;
                }
                if (!inputView.readGameRestart()) {
                    outputView.printEndMessage();
                    return;
                }
                break;
            }
        }
    }

    public List<Character> getRandomNumberList() {
        List<Character> randomNumberList = baseballService.createRandomNumberList();
        return randomNumberList;
    }

    // public gameProgress

}
