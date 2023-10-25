package baseball;

public class Exception {
    void generateInvalidAnswerLengthException() throws IllegalArgumentException {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_ANSWER_LENGTH_MESSAGE.getMessage());
    }

    void generateInvalidAnswerRangeException() throws IllegalArgumentException {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_ANSWER_RANGE_MESSAGE.getMessage());
    }

    void generateInvalidAnswerDuplicateException() throws IllegalArgumentException {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_ANSWER_DUPLICATE_MESSAGE.getMessage());
    }

    void generateInvalidRetryInputLengthException() throws IllegalArgumentException {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_RETRY_INPUT_LENGTH_MESSAGE.getMessage());
    }

    void generateInvalidRetryInputRangeException() throws IllegalArgumentException {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_RETRY_INPUT_RANGE_MESSAGE.getMessage());
    }
}
