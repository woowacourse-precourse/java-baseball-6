package baseball.fixture;

import baseball.model.UserNumbers;

public class UserNumbersFixture {

    public static UserNumbers createUserNumbers(final String input) {
        return UserNumbers.createFromInput(input);
    }
}
