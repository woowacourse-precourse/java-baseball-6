package racingcar.domain;

public abstract class RacingCar {
    String name;
    int location;
    RacingCar(String name) {
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
}
