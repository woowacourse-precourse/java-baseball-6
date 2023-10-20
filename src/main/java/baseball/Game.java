package baseball;

public class Game {

    public static void gameStart(){
        boolean gameRestart = true;

        while (gameRestart) {
            new BaseBallGameStart();

            BaseBallGameEnd baseBallGameEnd = new BaseBallGameEnd();
            gameRestart = baseBallGameEnd.orderCheck();
        }
    }
}


