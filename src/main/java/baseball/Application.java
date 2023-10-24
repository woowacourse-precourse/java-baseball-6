package baseball;

import baseball.controller.GameController;
;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
            GameController baseballGame = new GameController();
            baseballGame.start();
    }}