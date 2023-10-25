package baseball.exception;

public final class IndexOutOfBoundsInTripleException extends IndexOutOfBoundsException {

    public static final String INDEX_OUT_OF_BOUNDS_IN_TRIPLE_MESSAGE = "Triple의 index 범위를 벗어났습니다.";

    public IndexOutOfBoundsInTripleException() {
        super(INDEX_OUT_OF_BOUNDS_IN_TRIPLE_MESSAGE);
    }
}
