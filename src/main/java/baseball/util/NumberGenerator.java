package baseball.util;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private List<Integer> generatedNumber;

    public NumberGenerator() {
    }

    public List<Integer> generate() {
        this.generatedNumber = new ArrayList<>();
        while (generatedNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(
                    GameConstant.NUMBER_START_INCLUSIVE.getConstant(),
                    GameConstant.NUMBER_END_INCLUSIVE.getConstant());
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
