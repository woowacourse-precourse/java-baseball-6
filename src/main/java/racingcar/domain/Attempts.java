package racingcar.domain;

public class Attempts {
    private static final int MIN_ATTEMPT = 1;
    int value;

    Attempts(int value){
        validateAttempts(value);
        this.value = value;
    }

    void decreaseAttempts() {
        value--;
    }

    boolean isZero() {
        return this.value == 0;
    }

    private void validateAttempts(int attempts) throws IllegalArgumentException {
        if (attempts < MIN_ATTEMPT) {
            throw new IllegalArgumentException("[ERROR] 횟수가 1보다 작습니다.");
        }
    }
}
