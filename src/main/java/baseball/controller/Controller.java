package baseball.controller;

import static baseball.util.Converter.convertStringToInt;
import static baseball.util.Converter.convertStringToIntegerList;

import baseball.model.Computer;
import baseball.model.GuessNumber;
import baseball.model.Referee;
import baseball.model.State;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;

public class Controller {

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;

    public Controller(final ConsoleInputView consoleInputView,
                      final ConsoleOutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void start() {
        Computer computer = Computer.createDefault();
        Referee referee = new Referee(computer);
        consoleOutputView.printStartMessage();
        play(referee);
        consoleOutputView.printWinningMessage();
        int state = askMore();
        if (State.isMoreGame(state)) {
            start();
        }
    }

    private void play(final Referee referee) {
        GuessNumber guessNumber = guess();
        String result = calculateResult(referee, guessNumber);
        consoleOutputView.printGuessNumberResult(result);
        if (!referee.isGameOver(result)) {
            play(referee);
        }
    }

    private GuessNumber guess() {
        consoleOutputView.printGuessNumberInputMessage();
        String guessNumbers = consoleInputView.readGuessNumbers();
        return new GuessNumber(convertStringToIntegerList(guessNumbers));
    }

    private String calculateResult(final Referee referee, final GuessNumber guessNumber) {
        return referee.calculateResult(guessNumber.getGuessNumbers());
    }

    private int askMore() {
        consoleOutputView.printRestartOrFinishMessage();
        String stateNumber = consoleInputView.readGameStateNumber();
        int state = convertStringToInt(stateNumber);
        validate(state);
        return state;
    }

    private void validate(final int state) {
        State.validate(state);
    }
}
