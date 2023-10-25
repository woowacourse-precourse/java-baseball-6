package baseball.domain;

import static baseball.domain.numberBalls.NumberBallsConstant.MAX_NUMBER;
import static baseball.domain.numberBalls.NumberBallsConstant.MIN_NUMBER;
import static baseball.domain.numberBalls.NumberBallsConstant.NUMBER_COUNT;

import baseball.domain.numberBalls.NumberBalls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Pitcher {
    private NumberBalls numberBalls;

    private Pitcher() {
    }

    public static Pitcher create() {
        Pitcher pitcher = new Pitcher();
        pitcher.setNumbers(makeRandomNumbers());

        return pitcher;
    }

    private void setNumbers(NumberBalls numberBalls) {
        this.numberBalls = numberBalls;
    }

    private static NumberBalls makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();

        while (isNotFull(numberList)) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return NumberBalls.create(numberList);
    }

    private static boolean isNotFull(List<Integer> numberList) {
        return numberList.size() < NUMBER_COUNT;
    }

    public Result throwBalls(Hitter hitter) {
        return hitter.hit(numberBalls);
    }
}
