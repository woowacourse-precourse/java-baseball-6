package baseball.domain;

import baseball.view.GameValue;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber extends Number {
    private ComputerNumber(List<Integer> numbers) {
        super(numbers);
    }

    public static ComputerNumber getInstance() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < GameValue.NUMBER_SIZE.getValue()) {
            addUniqueRandomNumber(computerNumbers);
        }
        return new ComputerNumber(computerNumbers);
    }

    private static void addUniqueRandomNumber(List<Integer> numbers) {
        int number = Randoms.pickNumberInRange(GameValue.MIN_RANGE.getValue(), GameValue.MAX_RANGE.getValue());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
