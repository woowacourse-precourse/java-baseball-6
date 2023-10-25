package baseball.game;

import baseball.util.ResultMessage;

public class GameResult {
    public boolean printResult(int strikes, int balls) {
        boolean gameEnded = false;

        if (strikes == 3) {
            System.out.println("3스트라이크");
            printCorrectGameEnd();
            printFinishGame();
            return true;
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return gameEnded;
        }

        System.out.printf("%d볼 %d스트라이크%n", balls, strikes);
        return gameEnded;
    }

    public void printCorrectGameEnd() {
        System.out.println(ResultMessage.CORRECT_GAME + " " + ResultMessage.END_GAME);
    }

    public void printFinishGame() {
        System.out.println(ResultMessage.FINISH_GAME);
    }
}
