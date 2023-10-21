package baseball.generator;

public interface RandomNumberGenerator<T,R> {
    R generate(Integer size);

    default Boolean match(T input, R generatedNumber){
        return false;
    }
}
