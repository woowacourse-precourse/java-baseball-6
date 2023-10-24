package baseball.util;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private final List<Integer> generatedNumber;

    public NumberGenerator() {
        this.generatedNumber = new ArrayList<>();
    }

    public List<Integer> generate() {

        while (generatedNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(
                    GameConstant.GAME_START_INCLUSIVE.getConstant(), GameConstant.GAME_END_INCLUSIVE.getConstant());
            addNumber(number);
        }
        return generatedNumber;
    }

    private void addNumber(int number) {
        if (isValidNumber(number)) {
            generatedNumber.add(number);
        }
    }

    private boolean isValidNumber(int number) {
        return !generatedNumber.contains(number);
    }

}
