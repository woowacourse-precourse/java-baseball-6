package racingcar.domain;

import static racingcar.utils.GameUtils.randomPickNumber;
import static racingcar.utils.GameValidator.validateBlankCarName;
import static racingcar.utils.GameValidator.validateCarNameMaxLength;
import static racingcar.utils.GameValidator.validateCarNameMinLength;
import static racingcar.utils.GameValidator.validateCarNameSpaceBlack;

public class Car {

    private final String carName;
    private int forwardCount;


    public Car(final String carName) {
        this.carName = carName;
        validateCarNameSpaceBlack(carName);
        validateCarNameMaxLength(carName);
        validateBlankCarName(carName);
        validateCarNameMinLength(carName);
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
