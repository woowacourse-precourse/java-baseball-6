package game;

import static validation.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validation.Validation;

import java.util.ArrayList;
import java.util.List;


public class Game {
    static List<Integer> answer = new ArrayList<>();

    public Game() {
        answer = makeRandomNumber();
        printAnswer(answer);
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    private static void printAnswer(List<Integer> inputAnswer) {
        System.out.println("answer : " + inputAnswer);
    }

    public static void set() {
        System.out.println(START_STRING);
        Game game;
        do {
            game = new Game();
            game.start();
        } while (restart());
    }

    private void start() {
        GuessNumber();
    }


    private void GuessNumber() {
        String inputNumber;
        do {
            System.out.print(INPUT_STRING);
            inputNumber = Console.readLine();
            Validation.inputValidationCheck(inputNumber);
        } while (!equalToAnswer(inputNumber));
    }


    private static boolean equalToAnswer(String inputNumber) {
        int[] intInputNumber = changeToIntegerList(inputNumber);
        int strike = getStrike(intInputNumber);
        int ball = getBall(intInputNumber);

        printResult(strike, ball);
        if (endGame(strike)) {
            return true;
        }
        return false;
    }

    private static int[] changeToIntegerList(String inputNumber) {
        int[] inputList = new int[NUMBER_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            char input = inputNumber.charAt(i);
            if (!Character.isDigit(input)) {
                throw new IllegalArgumentException(WRONG_INPUT_TYPE);
            }
            inputList[i] = Character.getNumericValue(input);
        }
        return inputList;
    }

    private static int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (samePosition(inputNumber[i], answer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private static boolean samePosition(int ithInput, int ithAnswer) {
        if (ithInput == ithAnswer) {
            return true;
        }
        return false;
    }

    private static int getBall(int[] inputNumber) {
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (isInAnswer(inputNumber[i], answer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private static boolean isInAnswer(int ithInput, int ithAnswer) {
        if (ithInput != ithAnswer && answer.contains(ithInput)) {
            return true;
        }
        return false;
    }

    private static void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike);
        System.out.println();
        if (isNothing(strike, ball)) {
            printNothing();
        }
    }

    private static boolean isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    private static void printNothing() {
        System.out.println(NOTHING);
    }

    private static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
    }

    private static void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
        endGame(strike);
    }

    private static boolean endGame(int strike) {
        if (strike == STRIKE_SUCCESS) {
            System.out.println(END_GAME_STRING);
            return true;
        }
        return false;
    }

    private static boolean restart() {
        System.out.println(RESTART_STRING);
        int inputNumber = Validation.askRestart();

        if (inputNumber == RESTART) {
            return true;
        }
        return false;
    }
}
