package baseball;

import baseball.constant.ServiceMessage;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 시작
        BaseBallGame game = new BaseBallGame();
        System.out.print(ServiceMessage.START.serviceMessage);
        game.startGame();
    }
}
