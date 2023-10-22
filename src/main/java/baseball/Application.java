package baseball;

import static baseball.Constants.MAX_STRIKE;
import static baseball.Constants.NUM_LENGTH;
import static baseball.Constants.NEW_LINE;
import static baseball.Constants.RESTART;
import static baseball.Constants.EXIT;

import baseball.GameResult;
import baseball.Status;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> computer;
    private static List<Integer> user;
    private static int strike;
    private static int ball;

    public static void main(String[] args) {
        try {
            startBaseballGame();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void startBaseballGame() {
        printMessage(Status.GAME_START, NEW_LINE);
        boolean continueFlag = true;
        while (continueFlag) {
            createComputerNumber();
            while (strike != MAX_STRIKE) {
                inputUserNumber();
                compareNumbers();
                printGameResult();
            }
            continueFlag = inputContinueOrExit();
        }
    }

    public static void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void inputUserNumber() {
        printMessage(Status.INPUT_NUMBER, !NEW_LINE);
        String inputNumber = Console.readLine();
        if (inputNumber.length() != NUM_LENGTH) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < NUM_LENGTH; i++) {
            for(int j = 0; j < NUM_LENGTH; j++) {
                if (i == j) continue;
                if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        user = new ArrayList<>();
        for(int i = 0; i < NUM_LENGTH; i++) {
            char digit = inputNumber.charAt(i);
            if (!(digit >= '1' && digit <= '9')) {
                throw new IllegalArgumentException();
            }
            int number = digit - '0';
            user.add(number);
        }
    }

    public static void compareNumbers() {
        ball = 0;
        strike = 0;
        for(int i = 0; i < NUM_LENGTH; i++) {
            for(int j = 0; j < NUM_LENGTH; j++) {
                if (computer.get(i) != user.get(j)) continue;
                if (i == j) {
                    strike += 1;
                } else if (i != j) {
                    ball += 1;
                }
            }
        }
    }

    public static void printGameResult() {
        String message = GameResult.getMessage(ball, strike);
        System.out.println(message);
    }

    public static boolean inputContinueOrExit() {
        printMessage(Status.RESTART_OR_EXIT, NEW_LINE);
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber == RESTART) {
            ball = 0;
            strike = 0;
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

