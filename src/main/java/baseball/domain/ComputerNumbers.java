package baseball.domain;

import static baseball.enums.NumbersEnum.*;

import baseball.enums.NumbersEnum;
import baseball.vo.Number;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
public class ComputerNumbers implements Numbers{

    private final List<Number> computerNumbers;


    public ComputerNumbers() {
        List<Number> numbers = createNumbers();
        checkDuplication(numbers);
        checkLength(numbers);
        this.computerNumbers = new ArrayList<>(numbers);
    }

    private List<Number> createNumbers() {
        List<Number> numbers = new ArrayList<>();

        while (numbers.size() < LENGTH.showValue()) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(MIN_VALUE.showValue(), MAX_VALUE.showValue()));
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    public Number showNumberAt(int index) {
        Number number = computerNumbers.get(index);
        return new Number(number.showValue());
    }
    public boolean contains(Number number) {
        return computerNumbers.contains(number);
    }

}
