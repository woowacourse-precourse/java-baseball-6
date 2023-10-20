package baseball.controller.dto;

import baseball.model.UserNumbers;
import java.util.Arrays;
import java.util.List;

public class UserNumbersDto {

    private static final String NUMBERS_SPLITTER = "";

    private final String userNumbers;

    public UserNumbersDto(final String userNumbers) {
        this.userNumbers = userNumbers;
    }

    public UserNumbers toUserNumbers() {
        List<Integer> numbers = Arrays.stream(userNumbers.split(NUMBERS_SPLITTER))
            .map(Integer::parseInt)
            .toList();

        return UserNumbers.createUserNumbers(numbers);
    }
}
