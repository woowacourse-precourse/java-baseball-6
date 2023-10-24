package baseball.domain;

import baseball.utils.NumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터의 수를 생성하는 역할을 수행한다.
 */
public class ComputerNumbersGenerator {

    /**
     * 숫자 생성기와 최대 자릿수를 받아, 컴퓨터의 수를 생성한 후 반환한다.
     */
    public static ComputerNumbers generate(NumberGenerator numberGenerator, int digitNumber) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < digitNumber) {
            int generatedNumber = numberGenerator.generate();
            if (numbers.contains(generatedNumber)) {
                continue;
            }
            numbers.add(generatedNumber);
        }
        return new ComputerNumbers(numbers);
    }
}
