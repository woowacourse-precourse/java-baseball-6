package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckBall {

    protected static boolean giveBallResult(String tempBall, List<Integer> rightBall){

        List<Integer> integerTempBall = new ArrayList<>();
        try {
            integerTempBall = Arrays.stream(tempBall.split(""))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (integerTempBall.size() != 3) {
            throw new IllegalArgumentException();
        }

        int strike = 0;
        int ball = 0;
        boolean status = false;

        for (int i = 0; i < rightBall.size(); i++) {
            if (rightBall.get(i) == integerTempBall.get(i)) {
                strike++;
            }
            if (rightBall.contains(integerTempBall.get(i))) {
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
