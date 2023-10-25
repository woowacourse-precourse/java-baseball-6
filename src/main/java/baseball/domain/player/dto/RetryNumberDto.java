package baseball.domain.player.dto;

import java.util.Objects;

import static baseball.global.exception.ExceptionMessage.INPUT_CANNOT_BE_NULL;
import static baseball.global.exception.ExceptionMessage.INPUT_MUST_BE_ONE_OR_TWO;

public record RetryNumberDto(String number) {

    public RetryNumberDto {
        Objects.requireNonNull(number, INPUT_CANNOT_BE_NULL.getMessage());
        validateNumberIsOneOrTwo(number);
    }

    public static RetryNumberDto of(String number) {
        return new RetryNumberDto(number);
    }

    private void validateNumberIsOneOrTwo(String number) {
        if(!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException(INPUT_MUST_BE_ONE_OR_TWO.getMessage());
        }
    }
}
