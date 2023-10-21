package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = randomNumberGenerator();
            if (isDifferentNumber(computerNumbers, randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    // 난수 생성기
    private int randomNumberGenerator() {
        return Randoms.pickNumberInRange(1, 9);
    }

    // 새로 생성한 숫자가 이미 존재하는지 중복을 체크한다.
    private boolean isDifferentNumber(List<Integer> computerNumber, int randomNumber) {
        return !computerNumber.contains(randomNumber);
    }
}
