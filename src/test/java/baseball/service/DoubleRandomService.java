package baseball.service;

public class DoubleRandomService implements RandomService {
    public static final String NOT_RANGE_IN_ONE_TO_NINE_ERROR_MESSAGE = "랜덤 값이 1 ~ 9 사이가 아닙니다.";
    private int nowNumber;

    public DoubleRandomService(int nowNumber) {
        this.nowNumber = nowNumber;
    }

    @Override
    public int pickNumberInRange(final int startInclusive, final int endInclusive) {
        int returnNumber = this.nowNumber;
        if (startInclusive > nowNumber || nowNumber > endInclusive) {
            throw new IllegalArgumentException(NOT_RANGE_IN_ONE_TO_NINE_ERROR_MESSAGE);
        }

        nowNumber += 1;
        return returnNumber;
    }
}
