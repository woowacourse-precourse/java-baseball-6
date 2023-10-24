package matcher;

public interface InputMatcher<T, R> {
    void match(T input, T target);

    boolean isAllMatched();
}
