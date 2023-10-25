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
    private static boolean playing;

    private void init() {
        computerNumbers = service.generateNumbers();
    }

    public void play() {
        setPlaying(true);
        InputView.printStart();
        while (playing) {
            if (computerNumbers == null) {
                init();
            }
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

    private void restartOrNot(String input) {
        Command.validate(input);
        if (Command.isExit(input)) {
            setPlaying(false);
        }
        if (Command.isRestart(input)) {
            init();
        }
    }

    private Result getResult(BaseballNumbers userNumbers) {
        Result result = service.compare(computerNumbers, userNumbers);
        OutputView.printResult(result);
        userNumbers.clear();
        return result;
    }

    private BaseballNumbers getBaseballNumbers() {
        InputView.printCheat(computerNumbers); // 값 확인용
        InputView.printRequestingInput();
        return InputView.getUserNumbers();
    }

    private void setPlaying(boolean value) {
        playing = value;
    }

}
