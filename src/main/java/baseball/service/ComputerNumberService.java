package baseball.service;

import baseball.domain.ComputerNumber;
import baseball.view.GameValue;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumberService {

    private ComputerNumberService() {
    }

    public static ComputerNumber generateComputerNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < GameValue.NUMBER_SIZE.getValue()) {
            int number = Randoms.pickNumberInRange(GameValue.MIN_RANGE.getValue(), GameValue.MAX_RANGE.getValue());
            numbers.add(number);
        }
        return new ComputerNumber(ConversionService.convertSetToString(numbers));
    }
}
