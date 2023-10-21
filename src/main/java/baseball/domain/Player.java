package baseball.domain;

import baseball.exception.InputException;

import static java.util.Objects.isNull;

public class Player {
    public void validateAnswer(String sentence) throws InputException {
        if (isNull(sentence)) {
            throw new InputException("입력값에 Null 값이 확인되었습니다.");
        }

        if (isNotNumeric(sentence)) {
            throw new InputException("입력값이 숫자가 아닙니다.");
        }

        if (isTooShort(sentence)) {
            throw new InputException("입력값의 길이가 2이하입니다.");
        }

        if (isTooLong(sentence)) {
            throw new InputException("입력값의 길이가 4이상입니다.");
        }
    }

    private boolean isNotNumeric(String sentence) {
        return !sentence.matches("\\d+");
    }

    private boolean isTooLong(String sentence) {
        return sentence.length() > 3;
    }

    private boolean isTooShort(String sentence) {
        return sentence.length() < 3;
    }
}