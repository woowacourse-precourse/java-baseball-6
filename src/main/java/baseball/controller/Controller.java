package baseball.controller;

import baseball.domain.CommandType;
import baseball.domain.hints.HintProvider;
import baseball.domain.hints.HintType;
import baseball.domain.numbers.AnswerNumber;
import baseball.domain.numbers.AnswerNumberGenerator;
import baseball.domain.numbers.BaseBallNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private HintProvider hintProvider;
    private AnswerNumber answerNumber;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        play();
        end();
    }

    private void initGame() {
        answerNumber = AnswerNumber.createAnswerNumbers(new AnswerNumberGenerator());
        hintProvider = new HintProvider(answerNumber);

    }

    private void play() {
        BaseBallNumber playerNumber = null;

        while (playerNumber == null || !answerNumber.isSameWithAnswer(playerNumber)) {
            playerNumber = getPlayerNumber();
            getHint(playerNumber);
        }
    }

    private BaseBallNumber getPlayerNumber() {
        outputView.displayInputNumbers();
        String readNumbers = inputView.readNumbers();
        List<Integer> numbers = readNumbers.chars().mapToObj(num -> num - '0').toList();
        return new BaseBallNumber(numbers);
    }

    private void getHint(BaseBallNumber playerNumber) {
        Map<HintType, Integer> hintResult = hintProvider.compareNumbers(playerNumber);
        outputView.displayHint(hintResult);
    }

    private void end() {
        outputView.displayCorrectAnswer();
        outputView.displaySelect();
        runCommand(inputView.readCommand(CommandType.getAllCommandNumbers()));
    }

    private void runCommand(String command) {
        int number = Integer.parseInt(command);
        if (number == 1) {
            run();
        }
    }
}