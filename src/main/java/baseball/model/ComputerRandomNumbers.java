package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 1. 상대방(컴퓨터) 숫자 랜덤 생성
public class ComputerRandomNumbers {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;
    private static final int RANDOM_NUMBERS_SIZE = 3;
    private List<Integer> computer;

    public ComputerRandomNumbers() {
        generate();
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }

    public List<Integer> generate() {
        computer = new ArrayList<>();
        while (computer.size() < RANDOM_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
