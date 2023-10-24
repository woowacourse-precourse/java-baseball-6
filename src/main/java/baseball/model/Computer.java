package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BALL_NUMBER_LENGTH = 3;
    private static final int BALL_MIN_NUMBER = 1;
    private static final int BALL_MAX_NUMBER = 9;
    private List<Integer> computerNumbers;

    public List<Integer> generateComputerNumbers() {
        this.computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < BALL_NUMBER_LENGTH) {
            int randomNumber = randomNumberGenerator();
            if (isDifferentNumber(computerNumbers, randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    // 난수 생성기
    private int randomNumberGenerator() {
        return Randoms.pickNumberInRange(BALL_MIN_NUMBER, BALL_MAX_NUMBER);
    }

    // 새로 생성한 숫자가 이미 존재하는지 중복을 체크한다.
    private boolean isDifferentNumber(List<Integer> computerNumber, int randomNumber) {
        return !computerNumber.contains(randomNumber);
    }
}
