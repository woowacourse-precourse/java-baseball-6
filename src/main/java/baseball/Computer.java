package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computer = new ArrayList<>();
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Computer() {
        setNumber();
    }

    public void setNumber() {
        computer.clear();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int getStrikeCount(List<Integer> expectNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i, expectNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int getBallCount(List<Integer> expectNumberList) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isBall(i, expectNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isStrike(int index, int expectedNumber) {
        return computer.get(index) == expectedNumber;
    }

    private boolean isBall(int index, int expectedNumber) {
        return !isStrike(index, expectedNumber) && computer.contains(expectedNumber);
    }
}
