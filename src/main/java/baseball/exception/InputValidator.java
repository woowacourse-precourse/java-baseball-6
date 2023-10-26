package baseball.exception;

import static java.util.Objects.isNull;

public record InputValidator() {

    public void validateAnswer(String sentence) {
        if (isNull(sentence)) {
            throw new IllegalArgumentException(InputException.INVALID_NULL.getMessage());
        }

        if (isNotNumeric(sentence)) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }

        if (!isThreeLengthSentence(sentence)) {
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_THREE_LENGTH.getMessage());
        }

        if (isDuplicatedNumbers(sentence)) {
            throw new IllegalArgumentException(InputException.DUPLICATED_NUMBER.getMessage());
        }
    }

    public void validateContinue(String sentence) {
        if (isNull(sentence)) {
            throw new IllegalArgumentException(InputException.INVALID_NULL.getMessage());
        }

        if (isNotNumeric(sentence)) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }

        if (!isOneOrTwo(sentence)) {
            throw new IllegalArgumentException(InputException.NOT_ONE_OR_TWO.getMessage());
        }
    }

    private boolean isDuplicatedNumbers(String sentence) {
        return sentence.chars()
                .distinct()
                .count() != sentence.length();
    }

    private boolean isThreeLengthSentence(String sentence) {
        return sentence.length() == 3;
    }

    private boolean isOneOrTwo(String sentence) {
        return sentence.endsWith("1") || sentence.endsWith("2");
    }

    private static boolean isNotNumeric(String sentence) {
        return !sentence.matches("\\d+");
    }
}