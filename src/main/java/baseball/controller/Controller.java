package baseball.controller;

import static baseball.controller.mapper.ResultMapper.mapToStringWith;
import static baseball.util.Converter.convertStringToIntegerList;

import baseball.model.Computer;
import baseball.model.GuessNumber;
import baseball.model.State;
import baseball.util.BaseBallGameNumberGenerator;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;

    public Controller(final ConsoleInputView consoleInputView,
                      final ConsoleOutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void start() {
        consoleOutputView.printStartMessage();
        State state = State.RESTART;
        while (State.isMoreGame(state)) {
            play();
            state = askMoreGame();
        }
    }

    private void play() {
        Computer computer = Computer.createDefault(new BaseBallGameNumberGenerator());
        List<Integer> guessNumbers = new ArrayList<>();
        System.out.println(computer.getNumbers());
        while (!computer.isGameOver(guessNumbers)) {
            guessNumbers = getGuessNumbers();
            String result = getResult(computer, guessNumbers);
            consoleOutputView.printGuessNumberResult(result);
        }
        consoleOutputView.printWinningMessage();
    }

    private List<Integer> getGuessNumbers() {
        consoleOutputView.printGuessNumberInputMessage();
        String guessNumbers = consoleInputView.readStringCanConvertInt();
        GuessNumber guess = new GuessNumber(convertStringToIntegerList(guessNumbers));
        return guess.getGuessNumbers();
    }

    private String getResult(final Computer computer, final List<Integer> guessNumbers) {
        int ballCount = computer.countBalls(guessNumbers);
        int strikeCount = computer.countStrikes(guessNumbers);
        return mapToStringWith(ballCount, strikeCount);
    }

    private State askMoreGame() {
        consoleOutputView.printRestartOrFinishMessage();
        String stateNumber = consoleInputView.readStringCanConvertInt();
        return State.createWith(stateNumber);
    }
}
