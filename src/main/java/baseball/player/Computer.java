package baseball.player;

import baseball.util.Number;
import baseball.util.Result;
import camp.nextstep.edu.missionutils.Randoms;

public final class Computer extends Player {

    public Computer() {
        super();
    }

    @Override
    public void createNumbers() {
        while (!numbers.validateSize()) {
            numbers.addNumber(generateUniqueNumber());
        }
    }

    private Number generateUniqueNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        Number number = new Number(randomNumber);

        if (numbers.includeNumber(number) != -1) {
            return null;
        }
        number.checkValidate();

        return number;
    }

    @Override
    public Result compareWith(Player other) {
        return super.compareWith(other);
    }
}
