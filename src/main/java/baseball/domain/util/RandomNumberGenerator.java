package baseball.domain.util;

public interface RandomNumberGenerator<T, F> {
    T generate();

    F generateRandomNumbers();
}
