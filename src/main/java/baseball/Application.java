package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseBallGame baseBallGame = new BaseBallGame();
        do {
            baseBallGame.play();
        } while (baseBallGame.isRestart());
    }
}
