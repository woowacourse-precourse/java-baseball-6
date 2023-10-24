package baseball;

/**
 * 숫자 야구 게임의 결과값 경우의 수를 나타내기 위한 열거형.
 */
public enum Result {
    STRIKE(0),
    BALL(1),
    N_RESULT(2);  // Enum Result의 총 길이

    private final int index;

    Result(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
