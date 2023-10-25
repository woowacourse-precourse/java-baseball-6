package baseball.logic;

import baseball.logic.BaseballGame;
import baseball.util.InputUtil;

import static baseball.logic.BaseballGame.EXIT;
import static baseball.logic.BaseballGame.RESTART;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame;
        while(true){
            baseballGame = new BaseballGame();
            if (baseballGame.play() == EXIT) {
                InputUtil.closeConsole();
                return;
            }
        }
    }
}
