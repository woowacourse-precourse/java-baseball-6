package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerCreateRandomNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    // 컴퓨터의 랜덤한 숫자 생성
    public List<Integer> createRandomNumber() {
        List<Integer> computerInput = new ArrayList<>();
        while (computerInput.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerInput.contains(randomNumber)) {
                computerInput.add(randomNumber);
            }
        }
        return computerInput;
    }
}
