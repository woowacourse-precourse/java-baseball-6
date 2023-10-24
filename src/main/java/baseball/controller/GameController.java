package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Grade;
import baseball.domain.Player;
import baseball.utils.Constants;
import baseball.utils.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final Player player;
    private final Grade grade;
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidator inputValidator;

    public GameController(Computer computer, Player player, Grade grade, OutputView outputView, InputView inputView, InputValidator inputValidator) {
        this.computer = computer;
        this.player = player;
        this.grade = grade;
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public void start() {
        outputView.startGame();
        while (true) {
            play();
            outputView.isContinue();
            String input = inputView.getPlayerInput();
            vaildateFinish(input);
            int playerInput = player.getFinishInput(input);
            if (playerInput == Constants.EXIT) {
                outputView.exitGame();
                break;
            }
        }
    }

    private void play() {
        List<Integer> computerNumbers = computer.getComputerNumber();
        while (true) {
            outputView.inputNumber();
            String input = inputView.getPlayerInput();
            vaildateNumbers(input);
            List<Integer> playerNumbers = player.getPlayerNumbers(input);
            int[] scores = grade.getScore(computerNumbers, playerNumbers);
            String result = grade.getResult(scores);
            System.out.println(result);
            if (scores[1] == Constants.MAX_SIZE) break;
        }
    }

    private void vaildateNumbers(String input){
        if (!inputValidator.isValidNumbersInput(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void vaildateFinish(String input){
        if (!inputValidator.isValidFinishInput(input)) {
            throw new IllegalArgumentException();
        }
    }
}
