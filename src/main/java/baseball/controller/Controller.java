package baseball.controller;

import static baseball.model.State.PLAY;
import static baseball.model.State.isMoreGame;

import baseball.model.Computer;
import baseball.model.GuessNumber;
import baseball.model.State;
import baseball.util.BaseBallGameNumberGenerator;
import baseball.util.Converter;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;

    public Controller(final ConsoleInputView consoleInputView, final ConsoleOutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void start() {
        consoleOutputView.printStartMessage();
        State state = PLAY;
        while (isMoreGame(state)) {
            play();
            state = askMoreGame();
        }
    }

    private void play() {
        Computer computer = Computer.createWith(new BaseBallGameNumberGenerator());
        List<Integer> guessNumbers = new ArrayList<>();
        while (!computer.isGameOver(guessNumbers)) {
            guessNumbers = getGuessNumbers();
            getResult(computer, guessNumbers);
        }
        consoleOutputView.printWinningMessage();
    }

    private List<Integer> getGuessNumbers() {
        consoleOutputView.printGuessNumberInputMessage();
        String guessNumbers = consoleInputView.readLine();
        GuessNumber guess = new GuessNumber(Converter.stringToIntegerList(guessNumbers));
        return guess.getGuessNumbers();
    }

    private void getResult(final Computer computer, final List<Integer> guessNumbers) {
        int ballCount = computer.countBalls(guessNumbers);
        int strikeCount = computer.countStrikes(guessNumbers);
        consoleOutputView.printGameResult(ballCount, strikeCount);
    }

    private State askMoreGame() {
        consoleOutputView.printRestartOrEndMessage();
        String stateNumber = consoleInputView.readLine();
        return State.createWith(stateNumber);
    }
}
