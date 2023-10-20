package baseball.fixture;

import baseball.controller.dto.UserNumbersDto;
import baseball.model.UserNumbers;

public class UserNumbersFixture {

    public static UserNumbers createUserNumbersByString(final String numbers) {
        UserNumbersDto numbersRequest = new UserNumbersDto(numbers);
        return numbersRequest.toUserNumbers();
    }
}
