package baseball.dto;

import baseball.domain.Numbers;
import baseball.vo.Number;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStringDto {

    private String numbersString;

    public NumbersStringDto(String numbersString) {
        this.numbersString = numbersString;
    }


    public String show() {
        return new String(numbersString);
    }


}
