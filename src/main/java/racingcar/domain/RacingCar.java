package racingcar.domain;

import racingcar.exception.InvalidInputException;

public class RacingCar {
    String name;
    int location;
    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        location = 0;
    }

    public void moveRandom() {
        if (RandomNumberGenerator.generate() >= 4) location += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    private void validateName(String input_name) {
        if (input_name.length() >= 5 || input_name.isEmpty()) {
            throw new InvalidInputException("[ERROR] 이름의 길이가 다릅니다", input_name);
        }
    }
}
