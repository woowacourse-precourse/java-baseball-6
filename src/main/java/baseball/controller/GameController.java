package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.Command;
import baseball.domain.Result;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    GameService service = new GameService();
    BaseballNumbers computerNumbers;
    private static boolean playing = true;

    private void init() {
        computerNumbers = service.generateNumbers();
    }

    public void play() {
        InputView.printStart();
        while (playing) {
            BaseballNumbers userNumbers = getBaseballNumbers();
            Result result = getResult(userNumbers);
            checkResult(result);
        }
    }

    private void checkResult(Result result) {
        if (result.isAllStrikes()) {
            InputView.printGameOver();
            restartOrNot(InputView.getUserInput());
        }
    }

    private Result getResult(BaseballNumbers userNumbers) {
        Result result = service.compare(computerNumbers, userNumbers);
        OutputView.printResult(result);
        userNumbers.clear();
        return result;
    }

    private BaseballNumbers getBaseballNumbers() {
        if (computerNumbers == null) {
            init();
        }
//        InputView.printCheat(computerNumbers);
        InputView.printRequestingInput();
        return InputView.getUserNumbers();
    }

    private void restartOrNot(String input) {
        Command.validate(input);
        if (Command.isExit(input)) {
            playing = false;
        }
        if (Command.isRestart(input)) {
            init();
        }
    }

    public static void setPlayingTrue() {
        playing = true;
    }


}
