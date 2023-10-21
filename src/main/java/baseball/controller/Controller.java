package baseball.controller;

import baseball.domain.*;
import baseball.dto.HintDto;
import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        Referee referee = initGame();
        PlayerNumbers playerNumbers = null;
        while (playerNumbers == null || !referee.isSameWithAnswer(playerNumbers)) {
            playerNumbers = viewPlayerNumbersInput();
            System.out.println("playerNumbers = " + playerNumbers.getNumbers());
            viewHint(referee, playerNumbers);
        }
        outputView.displayCorrectAnswer();
        outputView.viewEndGame();
        inputView.readEndNumber();
    }

    private Referee initGame() {
        AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers(new AnswerNumberGenerator());
        return new Referee(answerNumbers);

    }

    private PlayerNumbers viewPlayerNumbersInput() {
        outputView.displayInputNumbers();
        String readNumbers = inputView.readNumbers();
        List<Integer> numbers = readNumbers.chars().mapToObj(num -> num - '0').toList();
        return new PlayerNumbers(numbers);
    }

    private void viewHint(Referee referee, PlayerNumbers playerNumbers) {
        int numberSize = playerNumbers.getNumbers().size();

        Map<HintType, Integer> hintMap = referee.getHint(playerNumbers);
        HintDto hintDto = service.getHintDto(new HashMap<>(hintMap), numberSize);
        outputView.displayHint(hintDto.getHint());
    }
}
