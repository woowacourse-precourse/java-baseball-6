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

    public void init() {
        computerNumbers = service.generateNumbers();
    }

    public void play() {
        InputView.printStart();
        while (playing) {
            if (computerNumbers == null) {
                computerNumbers = service.generateNumbers();
            }
            InputView.printCheat(computerNumbers);
            InputView.printRequestingInput();
            BaseballNumbers userNumbers = InputView.getUserNumbers();
            Result result = service.compare(computerNumbers, userNumbers);
            OutputView.printResult(result);
            userNumbers.clear();
            if (result.isAllStrikes()) {
                InputView.printGameOver();
                restartOrNot(InputView.getUserInput());
            }
        }
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
