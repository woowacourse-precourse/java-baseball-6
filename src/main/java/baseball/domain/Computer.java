package baseball.domain;

import static baseball.domain.number.NumberConstant.MAX_NUMBER;
import static baseball.domain.number.NumberConstant.MIN_NUMBER;
import static baseball.domain.number.NumberConstant.NUMBER_COUNT;

import baseball.domain.number.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Computer implements Player {
    private Numbers numbers;

    private Computer() {
    }

    public Computer create() {
        return new Computer();
    }

    public void resetNumbers() {
        this.numbers = makeRandomNumbers();
    }

    private static Numbers makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (isNotFull(numberList)) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return Numbers.create(numberList);
    }

    private static boolean isNotFull(List<Integer> numberList) {
        return numberList.size() < NUMBER_COUNT;
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }
}
