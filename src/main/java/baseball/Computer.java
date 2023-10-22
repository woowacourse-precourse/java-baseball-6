package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    Ball ball;

    public Computer() {

    }

    public Ball drawBall() {
        List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return ball = new Ball(pickNumbers);
    }

}
