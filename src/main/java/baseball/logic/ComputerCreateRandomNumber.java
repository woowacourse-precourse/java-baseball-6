package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerCreateRandomNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    // 컴퓨터의 랜덤한 숫자 생성
    public int createRandomNumber() {
        List<Integer> availableNumbers = createNumberLists();

        return createRandomNumberByPickNumbers(availableNumbers);
    }

    // Randoms.pickNumberInRange()을 이용하여 랜덤 인덱스 선택 후, 세 자리 수 생성
    private int createRandomNumberByPickNumbers(List<Integer> availableNumbers) {
        int createdNumber = 0;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            int selectedIdx = Randoms.pickNumberInRange(0, availableNumbers.size()-1);

            Integer selectedNumber = availableNumbers.remove(selectedIdx);

            createdNumber = createdNumber * 10 + selectedNumber;
        }

        return createdNumber;
    }

    // 사용 가능한 9자리 숫자 리스트 생성
    private List<Integer> createNumberLists() {
        List<Integer> availableNumbers = new ArrayList<>();

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            availableNumbers.add(i);
        }

        return availableNumbers;
    }
}
