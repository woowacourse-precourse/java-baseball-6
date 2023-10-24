package baseball.fixture;

import baseball.helper.StubNumberGenerator;
import baseball.model.Computer;

public class ComputerFixture {

    public static Computer createComputer(final String input) {
        return Computer.createFromGeneratedNumbers(new StubNumberGenerator(input));
    }
}
