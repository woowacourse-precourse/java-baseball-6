package baseball.util;

import baseball.enums.NumberEnum;
import baseball.model.NumberModel;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 숫자 생성
 */
public class RandomNumber {
    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
     * @return 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
     */
    public static NumberModel generate() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NumberEnum.NUMBER_LENGTH.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    NumberEnum.START_NUMBER.getValue(),
                    NumberEnum.END_NUMBER.getValue()
            );
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return new NumberModel(numbers.get(0), numbers.get(1), numbers.get(2));
    }
}
