package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class Game {
    static List<Integer> computer;
    static List<Integer> user;
    static boolean programRunning = true;
    static boolean gameRunning = true;

    private String CONTINUE = "1";
    private String EXIT = "2";

    private void printGameStartMessage() {
        System.out.println(Message.GAME_START.getMessage());
    }

    private void generateRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void getUserInput() {
        user = new ArrayList<>();

        System.out.print(Message.REQUESTING_INPUT.getMessage());
        String userInputString = readLine();

        if (userInputString.length() != 3) {
            throw new IllegalArgumentException(Message.INPUT_STRING_ERROR.getMessage());
        }

        int userInputInt = parseInt(userInputString);

        for (int i = 0; i < 3; i++) {
            user.add(userInputInt % 10);
            userInputInt = userInputInt / 10;
        }
        Collections.reverse(user);
    }

    private void printResult() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println(Message.THREE_STRIKE.getMessage());
            System.out.println(Message.GAME_END.getMessage());
            gameRunning = false;
        } else if (strike == 0 && ball == 0) {
            System.out.println(Message.NO_BALL_NO_STRIKE.getMessage());
        } else {
            if (ball != 0) System.out.print(ball + Message.BALL.getMessage());
            if (strike != 0) System.out.print(strike + Message.STRIKE.getMessage());
            System.out.println("");
        }
    }

    private void examineNewGameOrNot() {
        System.out.println(Message.GAME_RESTART.getMessage());

        String userInput = readLine();
        if (!userInput.equals(CONTINUE) && !userInput.equals(EXIT)) {
            throw new IllegalArgumentException(Message.INPUT_BOUND_ERROR.getMessage());
        }

        if (userInput.equals(EXIT)) {
            programRunning = false;
        }
    }

    private void startGame() {
        generateRandomNumber();
        gameRunning = true;
        while (gameRunning) {
            getUserInput();
            printResult();
        }
    }


    public void startProgram() {
        printGameStartMessage();
        programRunning = true;
        while (programRunning) {
            startGame();
            examineNewGameOrNot();
        }
    }
}