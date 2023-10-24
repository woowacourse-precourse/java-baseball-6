package baseball;

import static Constants.Constants.MAX_STRIKE;
import static Constants.Constants.NUM_LENGTH;
import static Constants.Constants.NEW_LINE;
import static Constants.Constants.RESTART;
import static Constants.Constants.EXIT;

import Entity.GameNumber;
import Entity.GameResult;
import Entity.GameScore;
import Entity.Status;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public static void initialize() {
        gameNumber = new GameNumber();
        gameScore = new GameScore();
    }

    public static void startBaseballGame() {
        printMessage(Status.GAME_START, NEW_LINE);
        boolean continueFlag = true;
        while (continueFlag) {
            createComputerNumber();
            while (gameScore.getStrike() != MAX_STRIKE) {
                inputUserNumber();
                calculateScore();
                printGameResult();
            }
            continueFlag = inputContinueOrExit();
        }
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
        printMessage(Status.INPUT_NUMBER, !NEW_LINE);
        String inputNumber = Console.readLine();

        List<Integer> userNumber = inputNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        gameNumber.setUser(userNumber);

        boolean isValidate = gameNumber.validateUserNumber();
        if (isValidate == false) {
            throw new IllegalArgumentException();
        }
    }

    public static void calculateScore() {
        gameScore.reset();
        gameScore.calculateScore(gameNumber);
    }

    public static void printGameResult() {
        String message = GameResult.getMessage(gameScore.getBall(), gameScore.getStrike());
        System.out.println(message);
    }

    public static boolean inputContinueOrExit() {
        printMessage(Status.RESTART_OR_EXIT, NEW_LINE);
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber == RESTART) {
            gameScore.reset();
            return true;
        } else if (inputNumber == EXIT) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void printMessage(Status status, boolean newLine) {
        String message = status.getMessage();
        if (newLine) {
            System.out.println(message);
        } else if (!newLine) {
            System.out.print(message);
        }
    }
}

