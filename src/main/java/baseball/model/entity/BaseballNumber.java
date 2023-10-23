package baseball.model.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class BaseballNumber {
    Integer number;

    public BaseballNumber() {
        this.number = Randoms.pickNumberInRange(1, 9);
    }

    public BaseballNumber (char c) {
        int number;
        try {
            number = Integer.parseInt(String.valueOf(c));
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        if(number < 1 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseballNumber that)) {
            return false;
        }
        return number.equals(that.number);
    }
}
