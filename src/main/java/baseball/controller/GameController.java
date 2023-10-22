package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameService;
import baseball.domain.Result;
import baseball.util.Parser;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    GameService service = new GameService();
    Parser parser = new Parser();
    BaseballNumbers computerNumbers;

    public static boolean playing = true;

    public void init() { computerNumbers = service.generateNumbers(); }

    public void play() {
        InputView.printStart();
        while (playing) {
            if (computerNumbers == null) computerNumbers = service.generateNumbers();
            InputView.printRequestingInput();
            BaseballNumbers userNumbers = getUserNumbers();
            Result result = service.compare(computerNumbers, userNumbers);
            OutputView.printResult(result);
            userNumbers.clear();
            if(result.isThreeStrikes()){
                InputView.printGameOver();
                restartOrNot(InputView.getUserInput());;
            }
        }
    }

    private BaseballNumbers getUserNumbers() {
        BaseballNumbers userNumbers = parser.parseStringToBaseballNumbers(InputView.getUserInput());
        return userNumbers;
    }

    private void restartOrNot(String input) {
        if(input.equals(InputView.EXIT)) playing = false;
        if(input.equals(InputView.RESTART)) init();
    }
}
