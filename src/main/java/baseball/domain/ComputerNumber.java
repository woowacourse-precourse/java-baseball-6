package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.constant.SystemConstant.*;

public class ComputerNumber extends Number {

    @Override
    public void setNumber() {
        StringBuilder select = new StringBuilder();

        while (select.length() < NUMBER_LENGTH) {
            String inputNumber = String.valueOf(Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX));

            if (!select.toString().contains(inputNumber)) {
                select.append(inputNumber);
            }
        }

        this.number = select.toString();
    }
}
