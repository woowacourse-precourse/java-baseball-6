package baseball.controller;

import static baseball.util.Converter.convertStringToInt;
import static baseball.util.Converter.convertStringToIntegerList;

import baseball.domain.Computer;
import baseball.domain.GuessNumber;
import baseball.domain.Referee;
import baseball.domain.State;
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
        Computer computer = Computer.createDefault();
        Referee referee = new Referee(computer);
        outputView.printStartMessage();
        play(referee);
        outputView.printWinningMessage();
        int state = askMore();
        if (State.isMoreGame(state)) {
            start();
        }
    }

    private void play(final Referee referee) {
        GuessNumber guessNumber = guess();
        String result = calculateResult(referee, guessNumber);
        outputView.printGuessNumberResult(result);
        if (!referee.isGameOver(result)) {
            play(referee);
        }
    }

    private GuessNumber guess() {
        outputView.printGuessNumberInputMessage();
        String guessNumbers = inputView.readGuessNumbers();
        return new GuessNumber(convertStringToIntegerList(guessNumbers));
    }

    private String calculateResult(final Referee referee, final GuessNumber guessNumber) {
        return referee.calculateResult(guessNumber.getGuessNumbers());
    }

    private int askMore() {
        outputView.printRestartOrFinishMessage();
        String stateNumber = inputView.readGameStateNumber();
        int state = convertStringToInt(stateNumber);
        validate(state);
        return state;
    }

    private void validate(final int state) {
        State.validate(state);
    }
}
