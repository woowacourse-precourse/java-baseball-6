package baseball.infra;

import static baseball.domain.NumberConstants.MAX_NUMBER;
import static baseball.domain.NumberConstants.NUMBER_LENGTH;
import static baseball.domain.NumberConstants.MIN_NUMBER;

import baseball.domain.Numbers;
import baseball.domain.NumbersGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumbersRandomGenerator implements NumbersGenerator {

    @Override
    public Numbers generate() {
        final List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < NUMBER_LENGTH) {
            final int pickedNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if(!numbers.contains(pickedNumber)) {
                numbers.add(pickedNumber);
            }
        }
        return new Numbers(numbers);
    }
}
