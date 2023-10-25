package baseball.domain.player.dto;

import baseball.global.exception.CustomObjects;

public record RetryNumberDto(String number) {

    public RetryNumberDto {
        CustomObjects.requireNonNull(number, "input cannot be null");
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
