package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        UserBalls userBalls = new UserBalls();
        List<Integer> userBallList = userBalls.inputBalls();
        ComputerBalls computerBalls = new ComputerBalls();
        List<Integer> computerBallList = computerBalls.inputComputerBalls();

        System.out.println(userBallList);
        System.out.println(computerBallList);
    }
}
