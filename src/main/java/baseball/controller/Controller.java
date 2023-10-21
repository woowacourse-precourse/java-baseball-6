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

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView,
                      final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Computer computer = new Computer();
        State state = new State();
        GuessNumber guessNumber = new GuessNumber();
        play(computer, guessNumber, state);
        askMore(state);
        while (state.isMoreGame()) {
            play(computer, guessNumber, state);
            askMore(state);
        }
    }

    private void play(final Computer computer, final GuessNumber guessNumber, final State state) {
        outputView.printStartMessage();
        while (!computer.isGameOver()) {
            guess(guessNumber);
            calculate(computer, guessNumber);
        }
        end(computer, state);
    }

    private void guess(final GuessNumber guessNumber) {
        outputView.printGuessNumberInputMessage();
        String guessNumbers = inputView.readGuessNumbers();
        guessNumber.changeGuessNumbers(convertStringToIntegerList(guessNumbers));
    }

    private void calculate(final Computer computer, final GuessNumber guessNumber) {
        GuessNumberResultResponse resultResponse = computer.calculateGuessNumberResult(guessNumber.getGuessNumbers());
        outputView.printGuessNumberResult(resultResponse.getResult());
    }

    private void askMore(final State state) {
        outputView.printRestartOrFinishMessage();
        String stateNumber = inputView.readGameStateNumber();
        state.changeState(convertStringToInt(stateNumber));
    }

    private void end(final Computer computer, final State state) {
        computer.end();
        state.end();
        outputView.printWinningMessage();
    }
}
