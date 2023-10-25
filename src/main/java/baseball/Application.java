package baseball;

import baseball.Controller.StartGame;
import baseball.Utils.GameMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GameMessage.START);

        // 생성자 호출 >> 게임시작!
        StartGame startGame = new StartGame();
        startGame.start();
    }
}
