package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class DefaultRandomNumberCreatorByDigit implements RandomNumberCreator {

    public Integer create(int digit) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers.stream()
                .reduce(0, (result, number) -> result * 10 + number);
    }

}
