package racingcar.domain;

public class SetNumberGenerator implements NumberGenerator {
    private final int setNumber;
    SetNumberGenerator(int setNumber) {
        this.setNumber = setNumber;
    }
    @Override
    public int generate() {
        return setNumber;
    }
}
