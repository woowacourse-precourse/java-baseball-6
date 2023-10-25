package baseball;


import java.util.ArrayList;
import java.util.List;
public class Game {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> user = new ArrayList<>();
    static boolean programRunning = true;
    static boolean gameRunning = true;

    static int strike = 0;
    static int ball = 0;

    private void printGameStartMessage() {

    }

    private int generateRandomNumber() {
    }

    private void getUserInput() {

    }

    private void printResult() {

    }

    private void examineNewGameOrNot() {

    }


    private void startGame() {
        generateRandomNumber();

        while (gameRunning) {
            getUserInput();
            printResult();
        }
    }

    private void resetData() {
    }

    public void startProgram() {
        printGameStartMessage();
        while (programRunning) {
            startGame();
            resetData();
            examineNewGameOrNot();
        }
    }
}