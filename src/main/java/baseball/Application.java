package baseball;

import static Constants.Constants.MAX_STRIKE;
import static Constants.Constants.NUM_LENGTH;
import static Constants.Constants.NEW_LINE;
import static Constants.Constants.RESTART;
import static Constants.Constants.EXIT;

import Entity.GameNumber;
import Entity.GameScore;
import Enum.Status;
import Manager.InputManager;
import Manager.PrintManager;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static GameNumber gameNumber;
    private static GameScore gameScore;

    public static void main(String[] args) {
        initialize();

        try {
            startBaseballGame();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void startBaseballGame() {
        PrintManager.showStatus(Status.GAME_START, NEW_LINE);

        do {
            playGame();
        }
        while (isRestart());
    }

    public static void playGame() {
        createComputerNumber();
        while (gameScore.getStrike() != MAX_STRIKE) {
            inputUserNumber();
            calculateScore();
        }
    }

    public static void initialize() {
        gameNumber = new GameNumber();
        gameScore = new GameScore();
    }

    public static void createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        gameNumber.setComputer(computerNumber);
    }

    public static void inputUserNumber() {
        PrintManager.showStatus(Status.INPUT_NUMBER, !NEW_LINE);

        String inputNumber = InputManager.getString();
        List<Integer> userNumber = InputManager.parseInput(inputNumber);
        gameNumber.setUser(userNumber);

        boolean isValidate = gameNumber.validateUserNumber();
        if (!isValidate) {
            throw new IllegalArgumentException();
        }
    }

    public static void calculateScore() {
        gameScore.reset();
        gameScore.calculateScore(gameNumber);

        PrintManager.showGameResult(gameScore.getBall(), gameScore.getStrike());
    }

    public static boolean isRestart() {
        PrintManager.showStatus(Status.RESTART_OR_EXIT, NEW_LINE);
        int inputNumber = InputManager.getInt();

        if (inputNumber == RESTART) {
            gameScore.reset();
            return true;
        } else if (inputNumber == EXIT) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}

