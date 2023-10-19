package baseball;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    static private void gameStart() {
        boolean gameRestart = true;

        while (gameRestart) {
            new BaseBallGameStart();

            BaseBallGameEnd baseBallGameEnd = new BaseBallGameEnd();
            gameRestart = baseBallGameEnd.orderCheck();
        }
    }
}