package baseball;

import baseball.Controller.BaseballGame;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.gameStartMessage();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.gameStart();
    }
}
