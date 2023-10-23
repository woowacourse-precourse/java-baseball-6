package baseball.controller;

import static baseball.model.State.PLAY;
import static baseball.model.State.isMoreGame;
import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;

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

    private static final String NEW_LINE = "\n";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다." + NEW_LINE;
    private static final String GUESS_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WINNING_MESSAGE =
            BASEBALL_GAME_NUMBER_DIGIT.getValue() + "개의 숫자를 모두 맞히셨습니다! 게임 종료" + NEW_LINE;
    private static final String RESTART_OR_FINISH_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + NEW_LINE;

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;

    public Controller(final ConsoleInputView consoleInputView, final ConsoleOutputView consoleOutputView) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
    }

    public void start() {
        consoleOutputView.print(START_MESSAGE);
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
        consoleOutputView.print(WINNING_MESSAGE);
    }

    private List<Integer> getGuessNumbers() {
        consoleOutputView.print(GUESS_NUMBER_INPUT_MESSAGE);
        String guessNumbers = consoleInputView.readLine();
        GuessNumber guess = new GuessNumber(Converter.stringToIntegerList(guessNumbers));
        return guess.guessNumbers();
    }

    private void getResult(final Computer computer, final List<Integer> guessNumbers) {
        int ballCount = computer.countBalls(guessNumbers);
        int strikeCount = computer.countStrikes(guessNumbers);
        consoleOutputView.printGameResult(ballCount, strikeCount);
    }

    private State askMoreGame() {
        consoleOutputView.print(RESTART_OR_FINISH_MESSAGE);
        String stateNumber = consoleInputView.readLine();
        return State.createWith(stateNumber);
    }
}
