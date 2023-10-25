package baseball;

public class Game {
    private static final String GAME_OVER_MESSAGE = "게임을 종료합니다.";

    public static void start() {
        Computer computer = new Computer();

        while (!Check.isThreeStrike()) {
            Check check = new Check(computer.getComputerNumber(), Player.getPlayerNumber());
            check.countBallAndStrike();
            check.printResult();
        }

        determineRestartGame(Player.isRestart());
    }

    public static void determineRestartGame(boolean result) {
        if (result) {
            restartGame();
        } else {
            quitGame();
        }
    }

    public static void restartGame() {
        Check.setIsThreeStrike(false);
        start();
    }

    public static void quitGame() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}