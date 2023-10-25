package baseball;

public class Game {
    static int target;
    static boolean programRunning = 1;
    static boolean gameRunning = 1;

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
        target = generateRandomNumber();

        while (gameRunning) {
            getUserInput();
            printResult();
        }
    }

    public void startProgram() {
        printGameStartMessage();
        while (programRunning) {
            startGame();
            examineNewGameOrNot();
        }
    }
}