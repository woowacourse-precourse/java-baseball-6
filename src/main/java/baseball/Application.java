package baseball;

import baseball.controller.BaseBallGame;
import baseball.view.Output;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.StartMessage();
        BaseBallGame Game = new BaseBallGame();
        Game.GameStart();
    }
}
