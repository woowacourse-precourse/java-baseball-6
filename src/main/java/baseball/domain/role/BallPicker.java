package baseball.domain.role;

public interface BallPicker {
    int pickNumberInRange(int minValues, int maxValues) throws IllegalAccessException;
}
