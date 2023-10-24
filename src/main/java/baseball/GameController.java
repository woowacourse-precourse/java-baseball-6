package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final int MAX_STRIKE_NUMBER = 3;
    private static final int MIN_STRIKE_AND_BALL_NUMBER = 0;
    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";

    Computer computer;
    Player player;

    public void startGame() {
        PrintCollection.printStartGame();
        playGame();
        endGame();
    }

    public void playGame() {
        computer = new Computer();
        int strikes = MIN_STRIKE_AND_BALL_NUMBER;
        int balls = MIN_STRIKE_AND_BALL_NUMBER;

        while (strikes != MAX_STRIKE_NUMBER) {
            PrintCollection.printInputNumber();
            player = new Player(Console.readLine());

            strikes = countStrikes(computer.getRandomNumber(), player.getInputNumber());
            balls = countBalls(computer.getRandomNumber(), player.getInputNumber());
            printStrikesAndBalls(strikes, balls);
        }
    }

    public void endGame() {
        boolean restartGame = true;

        while (restartGame) {
            PrintCollection.printRestartGame();
            String restart = Console.readLine();

            if (restart.equals(RESTART_NUMBER)) {
                playGame();
            } else if (restart.equals(END_NUMBER)) {
                restartGame = false;
            } else {
                throw new IllegalArgumentException(PrintCollection.RESTART_NUMBER_ERROR);
            }
        }
    }

    public int countStrikes(String computerNumber, String playerNumber) {
        int strikes = MIN_STRIKE_AND_BALL_NUMBER;

        for (int i = 0; i < computerNumber.length(); i++) {
            char computerNumberDigit = computerNumber.charAt(i);
            char playerNumberDigit = playerNumber.charAt(i);

            if (computerNumberDigit == playerNumberDigit) {
                strikes++;
            }
        }

        return strikes;
    }

    public int countBalls(String computerNumber, String playerNumber) {
        int balls = MIN_STRIKE_AND_BALL_NUMBER;

        for (int i = 0; i < computerNumber.length(); i++) {
            char computerNumberDigit = computerNumber.charAt(i);
            char playerNumberDigit = playerNumber.charAt(i);

            if (computerNumberDigit != playerNumberDigit && computerNumber.contains(
                    String.valueOf(playerNumberDigit))) {
                balls++;
            }
        }

        return balls;
    }

    public void printStrikesAndBalls(int strikes, int balls) {
        if (strikes < 1 && balls < 1) {
            PrintCollection.printNothing();
        }

        if (strikes >= 1 && balls < 1) {
            PrintCollection.printStrikes(strikes);
        }

        if (strikes < 1 && balls >= 1) {
            PrintCollection.printBalls(balls);
        }

        if (strikes >= 1 && balls >= 1) {
            PrintCollection.printStrikesAndBalls(strikes, balls);
        }
    }
}
