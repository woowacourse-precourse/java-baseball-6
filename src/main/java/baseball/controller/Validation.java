package baseball.controller;

import static baseball.model.Message.WRONG_OVERLAP_NUMBER;
import static baseball.model.Message.WRONG_RANGE_NUMBER;
import static baseball.model.Message.WRONG_SIZE_NUMBER;
import static baseball.model.NumberRule.NUMBER_RANGE_END;
import static baseball.model.NumberRule.NUMBER_RANGE_START;
import static baseball.model.NumberRule.NUMBER_SIZE;

import java.util.Arrays;

public class Validation {
    private static String[] number;

    public static void validationGameNumber(String number) {
        Validation.number = number.split("");
        numberRangeValidation();
        numberSizeValidation();
        numberOverlapValidation();
    }

    public static void validationReplayNumber(String number) {
        if (!(number.equals("1") || number.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    //1~9 사이 숫자인가?
    private static void numberRangeValidation() {
        for (String s : number) {
            int num = Integer.parseInt(s);
            if (!(NUMBER_RANGE_START.getNumber() <= num && num <= NUMBER_RANGE_END.getNumber())) {
                throw new IllegalArgumentException(WRONG_RANGE_NUMBER.getMessage());
            }
        }
    }

    //3자리 숫자인가?
    private static void numberSizeValidation() {
        //숫자 범위 유효성 검사에서 걸러지므로, 배열 크기만 검사
        if (number.length != NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException(WRONG_SIZE_NUMBER.getMessage());
        }
    }

    //중복된 숫자가 있는가?
    private static void numberOverlapValidation() {
        if (number.length != Arrays.stream(number).distinct().count()) {
            throw new IllegalArgumentException(WRONG_OVERLAP_NUMBER.getMessage());
        }
    }
}
