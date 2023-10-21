package baseball.generator;

public interface RandomNumberGenerator<T> {
    T generate(Integer size);

    default Boolean match(T matchingTargetNumber, T generatedNumber){
        return false;
    }
}
