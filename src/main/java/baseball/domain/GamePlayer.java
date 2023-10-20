package baseball.domain;

import baseball.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    public static final int FIXED_THREE_CIPHERS = 3;
    private final Validator validator = new Validator();
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void inputThreeNumbersString(String inputtedNumbers) {
        // 정수로 변환 검증
        int parsedValidatedInt = validator.parseValidatedInt(inputtedNumbers);
        // 세자리 수가 맞는지 검증
        validator.validateCiphers(parsedValidatedInt, FIXED_THREE_CIPHERS);

        for (int i = 0; i < FIXED_THREE_CIPHERS; i++) {
            int divisionBy = (int) Math.pow(10, FIXED_THREE_CIPHERS - i - 1);
            int parsedDigit = parsedValidatedInt / divisionBy;
            parsedValidatedInt = parsedValidatedInt % divisionBy;
            threeNumbers.add(parsedDigit);
        }
    }

    public List<Integer> getThreeNumbers() {
        return threeNumbers;
    }
}

