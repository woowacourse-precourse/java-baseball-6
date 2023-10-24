package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int BASEBALL_NUMBER_START = 1;
    private static final int BASEBALL_NUMBER_END = 9;


    //    램던번호 생성
    public int createRandomNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_START,
                    BASEBALL_NUMBER_END);
            if (!randomNumbers.contains(randomNumber)) {
                return randomNumber;
            }
        }
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            randomNumbers.add(createRandomNumber(randomNumbers));
        }
        return randomNumbers;
    }


}
