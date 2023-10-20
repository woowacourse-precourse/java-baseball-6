package baseball.util;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private final List<Integer> numbers;

    public NumberGenerator() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> generate() {
        int number = Randoms.pickNumberInRange(
                GameConstant.GAME_START_INCLUSIVE.getConstant(), GameConstant.GAME_END_INCLUSIVE.getConstant());
        if (isValidNumber(number)) {
            numbers.add(number);
        }
        return numbers;
    }

    private boolean isValidNumber(int number) {
        return !numbers.contains(number);
    }

}
