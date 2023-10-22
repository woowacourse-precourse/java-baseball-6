package baseball.controller;

import baseball.model.Message;
import java.util.List;

public class Validation {
    private int NUM_SIZE = Message.GAME_NUMBER_SIZE.getNumber();
    private int NUM_START = Message.GAME_NUMBER_RANGE_START.getNumber();
    private int NUM_END = Message.GAME_NUMBER_RANGE_END.getNumber();
    private String WRONG_RANGE_NUMBER = Message.WRONG_RANGE_NUMBER.getMessage();
    private String WRONG_SIZE_NUMBER = Message.WRONG_SIZE_NUMBER.getMessage();
    private String WRONG_OVERLAP_NUMBER = Message.WRONG_OVERLAP_NUMBER.getMessage();

    private List<Integer> number;

    public void validationGameNumber(List<Integer> number) {
        this.number = number;
        numberRangeValidation();
        numberSizeValidation();
        numberOverlapValidation();
    }

    //1~9 사이 숫자인가?
    private void numberRangeValidation() {
        for (Integer integer : number) {
            if (!(NUM_START <= integer && integer <= NUM_END)) {
                throw new IllegalArgumentException(WRONG_RANGE_NUMBER);
            }
        }
    }

    //3자리 숫자인가?
    private void numberSizeValidation() {
        if (number.size() != 3) {
            throw new IllegalArgumentException(WRONG_SIZE_NUMBER);
        }
    }

    //중복된 숫자가 있는가?
    private void numberOverlapValidation() {
        if (number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException(WRONG_OVERLAP_NUMBER);
        }
    }
}
