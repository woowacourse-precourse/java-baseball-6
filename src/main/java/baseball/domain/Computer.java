package baseball.domain;

import baseball.global.constant.CommonNumberType;
import baseball.global.utils.generator.NumberGenerator;
import baseball.global.utils.generator.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final RandomNumbers numbers;

    public Computer(NumberGenerator numberGenerator) {
        numbers = new RandomNumbers(numberGenerator.generate());
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }
}
