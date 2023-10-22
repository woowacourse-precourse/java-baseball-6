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

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        AnswerNumbers answerNumbers = createAnswerNumbers();
        play(answerNumbers);
        end();
    }

    private AnswerNumbers createAnswerNumbers() {
        return AnswerNumbers.createAnswerNumbers(new AnswerNumberGenerator());

    }

    private void play(AnswerNumbers answerNumbers) {
        HintProvider provider = new HintProvider();
        List<Integer> playerNumber = new ArrayList<>();
        List<Integer> answer = answerNumbers.getAnswerNumbers();
        while (!answerNumbers.isSameWithAnswer(playerNumber)) {
            playerNumber = getPlayerNumber();
            Map<HintType, Integer> hintResult = provider.compareNumbers(answer, playerNumber);
            outputView.displayHint(hintResult);
        }
    }

    private List<Integer> getPlayerNumber() {
        outputView.displayInputNumbers();
        String readNumbers = inputView.readNumbers();
        List<Integer> numbers = readNumbers.chars().mapToObj(num -> num - '0').toList();
        return new PlayerNumbers(numbers).getNumbers();
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
