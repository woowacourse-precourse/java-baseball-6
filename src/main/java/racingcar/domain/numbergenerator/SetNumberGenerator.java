package racingcar.domain.numbergenerator;

public class SetNumberGenerator implements NumberGenerator {
    private final int setNumber;
    public SetNumberGenerator(int setNumber) {
        this.setNumber = setNumber;
    }
    @Override
    public int generate() {
        return setNumber;
    }
}
