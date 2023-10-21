package baseball.controller;

import static baseball.util.Converter.convertStringToInt;
import static baseball.util.Converter.convertStringToIntegerList;

import baseball.domain.Computer;
import baseball.domain.GuessNumber;
import baseball.domain.State;
import baseball.domain.dto.GuessNumberResultResponse;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    private final Computer computer;
    private final GuessNumber guessNumber;
    private final InputView inputView;
    private final OutputView outputView;
    private final State state;

    public Controller(final Computer computer,
                      final GuessNumber guessNumber,
                      final InputView inputView,
                      final OutputView outputView,
                      final State state) {
        this.computer = computer;
        this.guessNumber = guessNumber;
        this.inputView = inputView;
        this.outputView = outputView;
        this.state = state;
    }

    public void start() {
        play();
        askMore();
        if (state.isMoreGame()) {
            start();
        }
    }

    private void play() {
        outputView.printStartMessage();
        while (!computer.isGameOver()) {
            guess();
            calculate();
        }
        end();
    }

    private void guess() {
        outputView.printGuessNumberInputMessage();
        String guessNumbers = inputView.readGuessNumbers();
        guessNumber.changeGuessNumbers(convertStringToIntegerList(guessNumbers));
    }

    private void calculate() {
        GuessNumberResultResponse resultResponse = computer.calculateGuessNumberResult(guessNumber.getGuessNumbers());
        outputView.printGuessNumberResult(resultResponse.getResult());
    }

    private void askMore() {
        outputView.printRestartOrFinishMessage();
        String stateNumber = inputView.readGameStateNumber();
        state.changeState(convertStringToInt(stateNumber));
    }

    private void end() {
        computer.end();
        state.end();
        outputView.printWinningMessage();
    }
}
