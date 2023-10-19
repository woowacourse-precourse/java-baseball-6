package baseball.domain;

import baseball.GameConstants;

public record Number(
        int number
) {
    public Number {
        if (number < GameConstants.MIN_NUMBER.getNumber() || number > GameConstants.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException("각 자릿수는 1~9 사이의 숫자만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Number) {
            return this.number == ((Number) obj).number();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
