package baseball.random;

import baseball.property.BaseballGameProperty;
import baseball.util.ArrayConverterUtil;
import baseball.validation.NumberRangeValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 민경수
 * @description random number generator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class RandomNumberGenerator extends NumberRangeValidator implements NumberGenerator {

    private int[] randomNumbers;

    public RandomNumberGenerator(BaseballGameProperty baseballGameProperty) {
        super(baseballGameProperty);
        this.randomNumbers = new int[baseballGameProperty.digit()];
    }

    @Override
    public int[] generateNumber() {
        randomNumbers = generateRandomNumbers();

        while(!isAllowedNumber(randomNumbers)) {
            randomNumbers = generateRandomNumbers();
        }

        return randomNumbers;
    }

    private int[] generateRandomNumbers() {
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = Randoms.pickNumberInRange(
                    super.usableSingleNumberFrom(),
                    super.usableSingleNumberTo()
            );
        }

        return randomNumbers;
    }

    private boolean isAllowedNumber(int[] randomNumbers) {
        List<Integer> list = this.generate(randomNumbers);
        if (list.contains(0)) {
            return false;
        }
        if (isDistinct(list)) {
            return false;
        }
        return true;
    }

    private List<Integer> generate(int[] randomNumbers) {

        return ArrayConverterUtil.converIntArrayToList(randomNumbers);
    }

    private boolean isDistinct(List<Integer> list) {
        Set<Integer> distinct = new HashSet<>(list);
        return list.size() != distinct.size();
    }

}