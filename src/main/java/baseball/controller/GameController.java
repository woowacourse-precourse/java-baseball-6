package baseball.controller;

import baseball.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void runGame() {
        outputView.printGameStart();
        outputView.printForInputThreeDigitNumbers();
        List<Integer> randomNumbers = randomNumberGenerator.generateRandomNumbers();
        System.out.println(randomNumbers);
        String inputNumbers = inputView.inputThreeDigitNumber();
        int[] playersNumbers = convertToArray(inputNumbers);
        checkGameResultOf(randomNumbers, playersNumbers);
    }

    private void checkGameResultOf(List<Integer> randomNumbers, int[] playersNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(playersNumbers[i])) {
                strike++;
                continue;
            }
            if (randomNumbers.contains(playersNumbers[i])) {
                ball++;
            }
        }
    }

    private int[] convertToArray(String inputNumbers) {
        int[] playersNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            playersNumbers[i] = Integer.parseInt(String.valueOf(inputNumbers.charAt(i)));
        }

        return playersNumbers;
    }
}
