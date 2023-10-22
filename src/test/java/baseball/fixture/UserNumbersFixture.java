package baseball.fixture;

import baseball.controller.dto.UserNumbersDto;
import baseball.model.UserNumbers;
import java.util.List;

public class UserNumbersFixture {

    public static UserNumbers createUserNumbersByString(final String numbers) {
        UserNumbersDto numbersRequest = new UserNumbersDto(numbers);
        List<String> stringNumbers = numbersRequest.toStringNumbers();
        return UserNumbers.createUserNumbers(stringNumbers);
    }
}
