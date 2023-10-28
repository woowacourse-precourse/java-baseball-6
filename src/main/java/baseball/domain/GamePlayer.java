package baseball.domain;

import baseball.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.Const.*;

public class GamePlayer {
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void initThreeNumbers(String inputtedNumbers) {
        if (threeNumbers.size() > 0) flushNumbers();
        inputThreeNumbersString(inputtedNumbers);
    }

    private void inputThreeNumbersString(String inputtedNumbers) {
        int parsedValidatedInt = validateNumbers(inputtedNumbers);
        for (int i = 0; i < FIXED_ANSWER_CIPHERS; i++) {
            int divisionBy = (int) Math.pow(10, FIXED_ANSWER_CIPHERS - i - 1);
            int parsedDigit = parsedValidatedInt / divisionBy;
            parsedValidatedInt = parsedValidatedInt % divisionBy;
            threeNumbers.add(parsedDigit);
        }
    }

    private int validateNumbers(String inputtedNumbers) {
        // 정수로 변환 검증
        int parsedValidatedInt = Validator.parseValidatedInt(inputtedNumbers);
        // 세자리 수가 맞는지 검증
        Validator.validateCiphers(parsedValidatedInt, FIXED_ANSWER_CIPHERS);

        // 숫자 중에 0이 포함이 안 됐는지 검증
        for (int i = 0; i < FIXED_ANSWER_CIPHERS; i++) {
            Validator.validateInRange(Character.getNumericValue(inputtedNumbers.charAt(i)), BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
        }

        return parsedValidatedInt;
    }

    private void flushNumbers() {
        threeNumbers.clear();
    }

    public int extractOneNumber(int index) {
        return threeNumbers.get(index);
    }
}