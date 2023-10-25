package baseball.controller.dto;

import java.util.Arrays;
import java.util.List;

public class UserNumbersDto {

    private static final String NUMBERS_SPLITTER = "";

    private final String userNumbers;

    public UserNumbersDto(final String userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<String> toStringNumbers() {
        return Arrays.stream(userNumbers.split(NUMBERS_SPLITTER))
            .toList();
    }
}
