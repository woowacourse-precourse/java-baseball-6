package baseball.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerCreateRandomNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    // 컴퓨터의 랜덤한 숫자 생성
    public int createRandomNumber() {
        List<Integer> availableNumbers = createNumberLists();
        Collections.shuffle(availableNumbers);

        return createRandomNumberByShuffleNumbers(availableNumbers);
    }

    // 섞은 리스트를 기반으로 리스트 앞에 있는 3자리 숫자를 선택하여 3자리 숫자 생성
    private int createRandomNumberByShuffleNumbers(List<Integer> availableNumbers) {
        int createdNumber = 0;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            int selectedNumber = availableNumbers.remove(0);
            createdNumber = createdNumber * 10 + selectedNumber;
        }

        return createdNumber;
    }

    // 사용 가능한 9자리 숫자 리스트 생성
    private List<Integer> createNumberLists() {
        List<Integer> availableNumbers = new ArrayList<>();

        for (int i = MIN_NUMBER; i <=MAX_NUMBER; i++) {
            availableNumbers.add(i);
        }

        return availableNumbers;
    }
}
