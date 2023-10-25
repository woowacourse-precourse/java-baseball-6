package baseball.domain.player.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static baseball.global.exception.ExceptionMessage.*;

public record PlayerNumbersDto(String playerNumbers) {

    public PlayerNumbersDto {
        Objects.requireNonNull(playerNumbers, INPUT_CANNOT_BE_NULL.getMessage());
        if (playerNumbers.equals("")) throw new IllegalArgumentException(INPUT_MUST_BE_THREE_DIGIT_NUMBERS.getMessage());
        validateInputNumbers(playerNumbers);
    }

    public static PlayerNumbersDto of(String playerNumbers) {
        return new PlayerNumbersDto(playerNumbers);
    }

    public void validateInputNumbers(String number) {
        List<String> inputNumbers = Arrays.stream(number.split("")).toList();
        validateInputNumbersSize(inputNumbers);
        validateInputIsNumbers(inputNumbers);
    }

    private void validateInputNumbersSize(List<String> inputNumbers) {
        if(inputNumbers.size() != 3) {
            throw new IllegalArgumentException(INPUT_MUST_BE_THREE_DIFFERENT_NUMBERS.getMessage());
        }
    }

    private void validateInputIsNumbers(List<String> inputNumbers) {
        for (String number : inputNumbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

}
