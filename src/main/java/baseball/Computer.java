package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computer = new ArrayList<>();
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    // 생성과 동시에 컴퓨터의 숫자를 설정합니다.
    public Computer() {
        setNumber();
    }

    // 컴퓨터의 숫자를 설정합니다.
    public void setNumber() {
        computer.clear();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    // 유저의 입력을 받아 스트라이크의 개수를 반환합니다.
    public int getStrikeCount(List<Integer> expectNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(i, expectNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // 유저의 입력을 받아 볼의 개수를 반환합니다.
    public int getBallCount(List<Integer> expectNumberList) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isBall(i, expectNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    // 현재 인덱스와 유저가 그 인덱스에 있을거라고 예측한 숫자를 통해 스트라이크 여부를 반환합니다.
    private boolean isStrike(int index, int expectedNumber) {
        return computer.get(index) == expectedNumber;
    }

    // 현재 인덱스와 유저가 그 인덱스에 있을거라고 예측한 숫자를 통해 볼 여부를 반환합니다.
    private boolean isBall(int index, int expectedNumber) {
        return !isStrike(index, expectedNumber) && computer.contains(expectedNumber);
    }
}
