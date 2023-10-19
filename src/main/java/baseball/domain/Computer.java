package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Numbers.*;


public class Computer {

    private Numbers answerNumbers;

    private Computer() {
    }

    public static Computer create() {
        Computer computer = new Computer();
        computer.setAnswerNumbers(Numbers.create(makeRandomNumberList()));

        return computer;
    }

    private static List<Integer> makeRandomNumberList() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public Result calculateResult(Player player) {
        List<Integer> answerNumberList = answerNumbers.getNumberList();
        List<Integer> inputNumberList = player.getNumberList();

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

    private void setAnswerNumbers(Numbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }
}
