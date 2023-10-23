package game;

import static validation.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import model.PlayerInput;
import validation.Validation;

import java.util.List;

import model.Answer;

public class Game {
    private final Answer answer;
    private static PlayerInput playerInput;

    public Game() {
        answer = new Answer();
        answer.setAnswerNumber();
        printAnswer(answer.getAnswerNumber());
    }

    private static void printAnswer(List<Integer> inputAnswer) {
        System.out.println("answer : " + inputAnswer);
    }

    public static void set() {
        printStartString();
        Game game;
        do {
            game = new Game();
            game.start();
        } while (game.restart());
    }

    private static void printStartString() {
        System.out.println(START_MESSAGE);
    }

    private void start() {
        GuessAnswer();
    }


    private void GuessAnswer() {
        do {
            playerInput = new PlayerInput(Console.readLine());
        } while (!equalToAnswer(playerInput.getPlayerInput()));
    }

    private String userInput() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    private boolean equalToAnswer(String inputNumber) {
        int[] intInputNumber = changeToIntegerList(inputNumber);
        int strike = getStrike(intInputNumber);
        int ball = getBall(intInputNumber);

        printResult(strike, ball);
        if (endGame(strike)) {
            return true;
        }
        return false;
    }

    private int[] changeToIntegerList(String inputNumber) {
        int[] inputList = new int[NUMBER_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            char input = inputNumber.charAt(i);
            inputList[i] = Character.getNumericValue(input);
        }
        return inputList;
    }

    private int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (samePosition(inputNumber[i], answer.getAnswerNumber().get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private boolean samePosition(int ithInput, int ithAnswer) {
        if (ithInput == ithAnswer) {
            return true;
        }
        return false;
    }

    private int getBall(int[] inputNumber) {
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (isInAnswer(inputNumber[i], answer.getAnswerNumber().get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isInAnswer(int ithInput, int ithAnswer) {
        if (ithInput != ithAnswer && answer.getAnswerNumber().contains(ithInput)) {
            return true;
        }
        return false;
    }

    private void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike);

        if (isNothing(strike, ball)) {
            printNothing();
        }
        System.out.println();
    }

    private boolean isNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    private void printNothing() {
        System.out.print(NOTHING);
    }

    private void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
    }

    private void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
    }

    private boolean endGame(int strike) {
        if (strike == STRIKE_SUCCESS) {
            System.out.println(END_GAME_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean restart() {
        System.out.println(RESTART_MESSAGE);
        int inputNumber = Validation.askRestart();

        if (inputNumber == RESTART) {
            return true;
        }
        return false;
    }
}
