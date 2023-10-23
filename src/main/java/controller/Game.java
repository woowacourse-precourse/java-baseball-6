package controller;

import static validation.Constant.END_GAME_MESSAGE;
import static validation.Constant.NUMBER_SIZE;
import static validation.Constant.RESTART;
import static validation.Constant.RESTART_MESSAGE;
import static validation.Constant.STRIKE_SUCCESS;

import java.util.List;
import model.Answer;
import model.PlayerInput;
import view.InputView;
import view.OutputView;

public class Game {
    private final Answer answer;

    public Game() {
        answer = new Answer();
        OutputView.printAnswer(answer.getAnswerNumber());
    }

    public static void set() {
        OutputView.printStartString();
        Game game;
        do {
            game = new Game();
            game.start();
        } while (game.restart());
    }

    private void start() {
        PlayerInput playerInput;
        do {
            playerInput = new PlayerInput(InputView.setPlayerInput());
        } while (!equalToAnswer(playerInput.getPlayerInput()));
    }

    private boolean equalToAnswer(String inputNumber) {
        int[] intInputNumber = changeToIntegerList(inputNumber);
        int strike = getStrike(intInputNumber);
        int ball = getBall(intInputNumber);

        OutputView.printResult(strike, ball);
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
        List<Integer> answerNumber = answer.getAnswerNumber();
        int strike = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (samePosition(inputNumber[i], answerNumber.get(i))) {
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
        List<Integer> answerNumber = answer.getAnswerNumber();
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (isInAnswer(inputNumber[i], answerNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isInAnswer(int ithInput, int ithAnswer) {
        List<Integer> answerInput = answer.getAnswerNumber();
        if (ithInput != ithAnswer && answerInput.contains(ithInput)) {
            return true;
        }
        return false;
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
        int inputNumber = InputView.setRestartInput();

        if (inputNumber == RESTART) {
            return true;
        }
        return false;
    }
}
