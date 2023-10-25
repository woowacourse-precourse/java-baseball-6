package baseballgame;

import static constants.Constant.*;

public class GameManager {

    public static final Game game = new Game();

    public void run(){
        System.out.println(START_GAME_CMD);

        do {
            // 게임 초기화
            game.init();

            // 컴퓨터가 숫자를 고른다.
            game.pickComputerNum();

            // 사용자가 게임을 한다.
            game.playGame();

            // 사용자에게 게임의 재시작을 묻는다.
            game.askRestart();
        }
        while(game.checkRestart());
    }

}
