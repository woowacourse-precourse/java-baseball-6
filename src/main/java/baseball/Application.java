package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import controller.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.gameStart();
    }
}
