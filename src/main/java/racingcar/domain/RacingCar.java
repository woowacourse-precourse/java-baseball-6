package racingcar.domain;

import static racingcar.constant.*;
import racingcar.exception.InvalidInputException;

public class RacingCar {
    String name;
    int location;
    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        location = CAR_INIT_LOCATION;
    }

    public void moveRandom() {
        if (RandomNumberGenerator.generate() >= CAR_MOVE_CONDITION_NUMBER) location += CAR_MOVE_DISTANCE;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    private void validateName(String input_name) {
        if (!(input_name.length() <= MAX_CAR_NAME_LENGTH) || input_name.isEmpty()) {
            throw new InvalidInputException("[ERROR] 이름의 길이가 다릅니다", input_name);
        }
    }
}
