package baseball;

import baseball.console.BaseBallGame;
import baseball.domain.BaseBall;
import baseball.util.Constant;

import java.io.IOException;

import static baseball.util.Constant.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        while(baseBallGame.playGame() != RESTART);
    }
}
