package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Numbers.*;


public class Computer {


    public Numbers createNumbers() {
        return new Numbers(createNumberList());
    }

    private List<Integer> createNumberList() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return numberList;
    }

    public Result calculateResult(Numbers answerNumbers, Numbers inputNumbers) {
        List<Integer> answerNumberList = answerNumbers.getNumberList();
        List<Integer> inputNumberList = inputNumbers.getNumberList();

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_COUNT; i++) {
            Integer number = inputNumberList.get(i);

            if (answerNumberList.get(i).equals(number)) {
                strike += 1;
                continue;
            }

            if (answerNumberList.contains(number)) {
                ball += 1;
            }
        }

        return new Result(ball, strike);
    }

}
