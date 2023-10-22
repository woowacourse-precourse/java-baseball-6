package baseball.controller;

import java.util.Arrays;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class ComputerController {
    GameNumber gameNumber = new GameNumber();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public void startGame() {
        outputView.printStartGame();
        gameNumber.setRandomNumbers();
        
        String inputNumber = Console.readLine();
        gameNumber.setInputNumber(inputNumber);
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        System.out.println("playerNumbers: " + Arrays.toString(playerNumbers));

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            countStrike(playerNumbers[i], i);
            countBall(playerNumbers[i], i);
        }
        
        provideHint();
    }

    private void countStrike(int playerNumber, int numberIndex) {
        if (gameNumber.getRandomNumbers()[numberIndex] == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(int playerNumber, int numberIndex) {
        int[] randomNumbers = gameNumber.getRandomNumbers();
        if ((randomNumbers[numberIndex] != playerNumber) && Arrays.stream(randomNumbers).anyMatch(num -> num == playerNumber)) {
            ballCount++;
        } 
    }

    private void provideHint() {
        String hint = "";

        if (ballCount > 0) {
            hint += ballCount + BALL_MESSAGE + " ";
        }

        if (strikeCount > 0) {
            hint += strikeCount + STRIKE_MESSAGE + " ";
        }

        if (ballCount == 0 && strikeCount == 0) {
            hint += NOTHING_MESSAGE;
        }

        System.out.println(hint);
    }
}
