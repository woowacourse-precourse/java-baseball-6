package baseball.exception.guess_number;

import static baseball.util.Converter.convertIntegerListToString;

import java.util.List;

public class NotUniqueNumberException extends IllegalArgumentException {

    public NotUniqueNumberException(final List<Integer> guessNumbers) {
        super("예측하신 숫자에 중복된 값이 존재합니다. 다시 입력해주세요. 예측하신 숫자: " + convertIntegerListToString(guessNumbers));
    }
}
