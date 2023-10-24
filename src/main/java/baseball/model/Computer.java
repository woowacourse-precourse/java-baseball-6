package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int FIXED_LIST_SIZE = 3;
    private static final int MIN_OF_NUMBER_RANGE = 1;
    private static final int MAX_OF_NUMBER_RANGE = 9;
    private List<Integer> randomNumberList;

    public List<Integer> getComputerRandomNumber() {
        randomNumberList = new ArrayList<>();

        return generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        int newRandomNumber;

        while(randomNumberList.size() < FIXED_LIST_SIZE) {

            newRandomNumber = Randoms.pickNumberInRange(MIN_OF_NUMBER_RANGE, MAX_OF_NUMBER_RANGE);

            if (!randomNumberList.contains(newRandomNumber)) {
                randomNumberList.add(newRandomNumber);
            }

        }

        return randomNumberList;
    }

}
