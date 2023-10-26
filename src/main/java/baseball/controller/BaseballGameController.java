package baseball.controller;

import baseball.model.Computer;
import baseball.model.ComputerGenerator;
import baseball.model.GameOption;
import baseball.model.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {

    public void play() {
        OutputView.printGameStartMessage();
        run();
    }

    private void run() {
        process(ComputerGenerator.generate());
        askForContinue();
    }

    private void process(final Computer computer) {
        final PlayResult playResult = computer.compute(guessNumbers());
        OutputView.printResult(playResult);

        if (!playResult.isClear()) {
            process(computer);
        }
    }

    private List<Integer> guessNumbers() {
        return InputView.readNumbers();
    }

    private void askForContinue() {
        final GameOption option = createGameOption();

        if (option.isContinue()) {
            run();
        }
    }

    private GameOption createGameOption() {
        return GameOption.find(InputView.readOptionNumber())
                .orElseThrow(IllegalArgumentException::new);
    }
}
