package baseball;

public interface UserInput<T> {
    T input(Integer inputSize);

    void close();
}
