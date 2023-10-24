package baseball;

import static baseball.model.Constant.END_GAME;
import static baseball.model.Constant.NUMBER_RANGE_END;
import static baseball.model.Constant.NUMBER_RANGE_START;
import static baseball.model.Constant.NUMBER_SIZE;
import static baseball.model.Constant.REPLAY_GAME;
import static baseball.model.Constant.WRONG_OVERLAP_NUMBER;
import static baseball.model.Constant.WRONG_RANGE_NUMBER;
import static baseball.model.Constant.WRONG_SIZE_NUMBER;

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
        if (!(number.equals(REPLAY_GAME) || number.equals(END_GAME))) {
            throw new IllegalArgumentException();
        }
    }

    //1~9 사이 숫자인가?
    private static void numberRangeValidation() {
        for (String s : number) {
            int num = Integer.parseInt(s);
            if (!(NUMBER_RANGE_START <= num && num <= NUMBER_RANGE_END)) {
                throw new IllegalArgumentException(WRONG_RANGE_NUMBER);
            }
        }
    }

    //3자리 숫자인가?
    private static void numberSizeValidation() {
        //숫자 범위 유효성 검사에서 걸러지므로, 배열 크기만 검사
        if (number.length != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_SIZE_NUMBER);
        }
    }

    //중복된 숫자가 있는가?
    private static void numberOverlapValidation() {
        if (number.length != Arrays.stream(number).distinct().count()) {
            throw new IllegalArgumentException(WRONG_OVERLAP_NUMBER);
        }
    }
}
