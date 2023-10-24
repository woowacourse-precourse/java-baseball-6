package baseball;

import Game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame;
        boolean continueFlag = true;
        // TODO: 프로그램 구현
        do{
            baseballGame  = new BaseballGame();
            baseballGame.play();
            continueFlag = baseballGame.sm.isContinue();
        }
        while (continueFlag);
    }
}
