package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    private final Set<Integer> computerBall = new LinkedHashSet<>();

    public Set<Integer> generateBalls() {
        while (computerBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (computerBall.contains(randomNumber)) {
                continue;
            }
            computerBall.add(randomNumber);
            System.out.println(computerBall);
        }
        return computerBall;
    }
}