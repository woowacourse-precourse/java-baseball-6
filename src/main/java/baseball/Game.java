package baseball;

public class Game {

    public static void gameStart(){
        boolean isNotGameRestarted = false;

        while (!isNotGameRestarted) {
            new BaseBallGameStart();

            BaseBallGameEnd baseBallGameEnd = new BaseBallGameEnd();
            isNotGameRestarted = baseBallGameEnd.orderCheck();
        }
    }
}


