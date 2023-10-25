package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    static final int NUMBER_RANGE = 3;
    static final int MINIUM_NUMBER = 1;
    static final int MAXIUM_NUMBER = 9;

    private final Set<Integer> computerBall = new LinkedHashSet<>();

    public Set<Integer> generateBalls() {
        initComputerBall();
        while (computerBall.size() < NUMBER_RANGE) {
            int randomNumber = Randoms.pickNumberInRange(MINIUM_NUMBER, MAXIUM_NUMBER);
            if (computerBall.contains(randomNumber)) {
                continue;
            }
            computerBall.add(randomNumber);
            System.out.println(computerBall);
        }
        return computerBall;
    }

    public void initComputerBall() {
        computerBall.clear();
    }

    public Set<Integer> getComputerNumber() {
        return computerBall;
    }
}