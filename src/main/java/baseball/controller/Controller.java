package baseball.controller;

import baseball.domain.hints.HintProvider;
import baseball.domain.hints.HintType;
import baseball.domain.numbers.AnswerNumberGenerator;
import baseball.domain.numbers.AnswerNumbers;
import baseball.domain.numbers.PlayerNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private HintProvider hintProvider;
    private AnswerNumbers answerNumbers;

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
        answerNumbers = AnswerNumbers.createAnswerNumbers(new AnswerNumberGenerator());
        hintProvider = new HintProvider(answerNumbers);

    }

    private void play() {
        List<Integer> playerNumber = new ArrayList<>();

        while (!answerNumbers.isSameWithAnswer(playerNumber)) {
            playerNumber = getPlayerNumber();
            getHint(playerNumber);
        }
    }

    private List<Integer> getPlayerNumber() {
        outputView.displayInputNumbers();
        String readNumbers = inputView.readNumbers();
        List<Integer> numbers = readNumbers.chars().mapToObj(num -> num - '0').toList();
        return new PlayerNumbers(numbers).getNumbers();
    }

    private void getHint(List<Integer> playerNumber) {
        Map<HintType, Integer> hintResult = hintProvider.compareNumbers(playerNumber);
        outputView.displayHint(hintResult);
    }

    private void end() {
        outputView.displayCorrectAnswer();
        outputView.displaySelect();

        runCommand(inputView.readCommand());
    }

    private void runCommand(String command) {
        int number = Integer.parseInt(command);
        if (number == 1) {
            run();
        }
    }
}
