package baseball.player;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Computer extends Player {
    private final int MAX_SIZE = 3;

    @Override
    public void createNumbers() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            addUniqueNumber(numbers);
        }

        this.numbers = new Numbers(numbers);
    }

    private void addUniqueNumber(List<Number> numbers) {
        Number number = generateNumber(numbers);

        NumberValidator.checkValidate(number);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private Number generateNumber(List<Number> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return new Number(randomNumber);
    }

    @Override
    public Result compareWith(Player other) {
        return super.compareWith(other);
    }
}
