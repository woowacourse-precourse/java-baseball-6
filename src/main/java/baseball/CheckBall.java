package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckBall {

    protected static boolean giveBallResult(List<Integer> resultBall, List<Integer> rightBall){

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < rightBall.size(); i++) {
            if (rightBall.get(i) == resultBall.get(i)) {
                strike++;
            }
            if (rightBall.contains(resultBall.get(i))) {
                ball++;
            }
        }

        ball -= strike;

        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ball != 0) {
            System.out.format("%d볼 ", ball);
        }

        if (strike != 0) {
            System.out.format("%d스트라이크", strike);
        }

        System.out.println();
        return false;
    }
}
