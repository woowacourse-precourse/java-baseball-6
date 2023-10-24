package baseball.player;

import baseball.util.Number;
import baseball.util.Numbers;
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

        numbers.checkDuplicate(number);
        number.checkValidate();

        return number;
    }
}
