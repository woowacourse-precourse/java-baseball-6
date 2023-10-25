package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.Numbers;
import baseball.service.AnswerService;
import baseball.service.ExceptionHandlingService;
import baseball.view.View;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {

    private final AnswerService answerService;
    private final View view;
    private final ExceptionHandlingService exceptionHandlingService;

    public BaseballController(AnswerService answerService, View view, ExceptionHandlingService exceptionHandlingService) {
        this.answerService = answerService;
        this.view = view;
        this.exceptionHandlingService = exceptionHandlingService;
    }

    public void run() {
        view.startGame();
        saveAnswer();
    }

    private void saveAnswer() {
        answerService.saveAnswer();
        getNumbers();
    }

    private void getNumbers() {
        String[] numbersString = view.getNumbers().split("");

        exceptionHandlingService.checkGetNumbers(numbersString);

        Numbers numbers = numbersStringToInteger(numbersString);
        Hint hint = answerService.getHint(numbers);
        postHint(hint);
    }

    private void postHint(Hint hint) {
        view.postHint(hint);

        if (hint.getStrike() != 3) {
            getNumbers();
        } else {
            startNewGame();
        }
    }

    private void startNewGame() {
        String select = view.startNewGame();

        exceptionHandlingService.checkStartNewGame(select);

        if (select.equals("1")) {
            saveAnswer();
        } else if (select.equals("2")) {
            endGame();
        }
    }

    private void endGame() {
        view.endGame();
    }

    private static Numbers numbersStringToInteger(String[] numbersString) {
        List<Integer> numbersInteger = new ArrayList<>();
        for (String numberString : numbersString) {
            Integer numberInteger = Integer.parseInt(numberString);
            numbersInteger.add(numberInteger);
        }
        Numbers numbers = new Numbers(numbersInteger);
        return numbers;
    }
}
