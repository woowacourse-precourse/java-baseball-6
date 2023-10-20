package baseball.domain;

import baseball.controller.GameConstants;

public record Number(
        int number
) {
    public Number {
        if (number < GameConstants.MIN_NUMBER.getNumber() || number > GameConstants.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException("각 자릿수는 1~9 사이의 숫자만 가능합니다.");
        }
    }
}
