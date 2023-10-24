package baseball.manager;

public interface NumberMatcher<T> {
    default Boolean match(T matchingTargetNumber, T generatedNumber){
        return false;
    }
}
