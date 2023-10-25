package baseball.player;

import baseball.number.Number;
import baseball.number.Numbers;
import baseball.result.Result;
import baseball.util.NumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public final class User extends Player {

    @Override
    public void createNumbers() {
        String[] input = inputNumbers();

        List<Number> numbers = new ArrayList<>();
        for (String obj : input) {
            Number number = NumberValidator.convertToNumber(obj);

            NumberValidator.checkValidate(number);
            checkDuplicate(numbers, number);

            numbers.add(number);
        }

        this.numbers = new Numbers(numbers);
    }

    private void checkDuplicate(List<Number> numbers, Number number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private String[] inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().split("");
    }

    @Override
    public Result compareWith(Player other) {
        return super.compareWith(other);
    }
}
