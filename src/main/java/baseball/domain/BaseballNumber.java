package baseball.domain;

public class BaseballNumber {
    private int ballNumber;

    public BaseballNumber(int baseballNumber) {
        this.ballNumber = baseballNumber;
    }

    public BaseballNumber(char userInputNumber) {
        this.ballNumber = Character.getNumericValue(userInputNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseballNumber)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        BaseballNumber other = (BaseballNumber) obj;
        return ballNumber == other.ballNumber;
    }
}
