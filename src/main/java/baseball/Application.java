package baseball;

import static baseball.constant.MessageConst.START_GAME_MSG;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_GAME_MSG);
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.run();
    }
}
