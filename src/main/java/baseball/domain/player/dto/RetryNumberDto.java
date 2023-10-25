package baseball.domain.player.dto;

import java.util.Objects;

public record RetryNumberDto(String number) {

    public RetryNumberDto {
        Objects.requireNonNull(number, "input cannot be null");
        validateNumberIsOneOrTwo();
    }

    public static RetryNumberDto of(String number) {
        return new RetryNumberDto(number);
    }

    private void validateNumberIsOneOrTwo() {
        if(!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException("1 혹은 2의 숫자만 입력 가능");
        }
    }
}
