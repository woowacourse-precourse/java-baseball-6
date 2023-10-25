package baseball;

import baseball.domain.BaseballNumber;

public abstract class CountStrategy {
    protected BaseballNumber computerBaseballNumber;
    protected BaseballNumber userBaseballNumber;

    public CountStrategy(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        this.computerBaseballNumber = computerBaseballNumber;
        this.userBaseballNumber = userBaseballNumber;
    }

    public abstract int counting(int index);

    protected int plusCount(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }
}
