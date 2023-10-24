package baseball.view;

@FunctionalInterface
public interface InputProvider<T> {
    T readNonNullInput();
}
