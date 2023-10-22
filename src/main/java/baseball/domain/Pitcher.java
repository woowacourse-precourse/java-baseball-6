package baseball.domain;

import static baseball.domain.numbers.NumbersConstant.MAX_NUMBER;
import static baseball.domain.numbers.NumbersConstant.MIN_NUMBER;
import static baseball.domain.numbers.NumbersConstant.NUMBER_COUNT;

import baseball.domain.numbers.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Pitcher {
    private Numbers numbers;

    private Pitcher() {
    }

    public static Pitcher create() {
        Pitcher pitcher = new Pitcher();
        pitcher.setNumbers(makeRandomNumbers());

        return pitcher;
    }

    private void setNumbers(Numbers numbers) {
        this.numbers = numbers;
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

    public Result battleWithHitter(Hitter hitter) {
        return hitter.battleByNumbers(numbers);
    }
}
