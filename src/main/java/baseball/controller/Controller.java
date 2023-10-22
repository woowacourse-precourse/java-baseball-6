package baseball.controller;

import static baseball.util.Converter.convertStringToInt;
import static baseball.util.Converter.convertStringToIntegerList;

import baseball.controller.mapper.ResultMapper;
import baseball.model.Computer;
import baseball.model.GuessNumber;
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
        ResultMapper resultMapper = new ResultMapper();
        consoleOutputView.printStartMessage();
        play(computer, resultMapper);
        consoleOutputView.printWinningMessage();
        int state = askMore();
        if (State.isMoreGame(state)) {
            start();
        }
    }

    private void play(final Computer computer, final ResultMapper resultMapper) {
        GuessNumber guessNumber = guess();
        int ballCount = computer.countBalls(guessNumber.getGuessNumbers());
        int strikeCount = computer.countStrikes(guessNumber.getGuessNumbers());
        String result = resultMapper.makeResult(ballCount, strikeCount);
        consoleOutputView.printGuessNumberResult(result);
        if (!computer.isGameOver(strikeCount)) {
            play(computer, resultMapper);
        }
    }

    private GuessNumber guess() {
        consoleOutputView.printGuessNumberInputMessage();
        String guessNumbers = consoleInputView.readGuessNumbers();
        return new GuessNumber(convertStringToIntegerList(guessNumbers));
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
