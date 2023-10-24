package baseball.player;

import baseball.util.Number;
import baseball.util.Result;
import camp.nextstep.edu.missionutils.Console;

public final class User extends Player {

    public User() {
        super();
    }

    @Override
    public void createNumbers() {
        String[] input = inputNumbers();

        for (String obj : input) {
            Number number = convertToNumber(obj);

            number.checkValidate();
            numbers.checkDuplicate(number);

            numbers.addNumber(number);
        }

        if (!numbers.validateSize()) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private Number convertToNumber(String obj) {
        try {
            int parsedNumber = Integer.parseInt(obj);
            Number number = new Number(parsedNumber);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
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
