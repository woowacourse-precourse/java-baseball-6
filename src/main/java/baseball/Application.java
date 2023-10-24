package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ForStartGame forStartGame = new ForStartGame();
        List<Integer> answer = forStartGame.init();

        System.out.println("숫자 야구 게임을 시작합니다.");

        forStartGame.play(answer);
    }
}
