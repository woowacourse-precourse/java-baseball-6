package racingcar.domain;

import static racingcar.utils.GameUtils.randomPickNumber;

public class Car {

    private final String carName;
    private int forwardCount;

    public Car(final String carName) {
        this.carName = carName;
    }

    public void validateDuplicateCarName() {
    }

    public void validateDuplicateCarLength() {
    }


    public String getCarName() {
        return this.carName;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public String getCarValue() {
        if (hasRandomValueIsFourOrGreater(randomPickNumber())) {
            this.forwardCount++;
        }
        return "-".repeat(forwardCount);
    }

    public boolean hasRandomValueIsFourOrGreater(int randomValue) {
        return randomValue >= 4;
    }
}
