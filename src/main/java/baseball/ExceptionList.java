package baseball;

import java.util.List;

public class ExceptionList {
    public static void validNumbers(List<Integer> numbers) {
        if(numbers.size() != 3) {
            throw new IllegalArgumentException("예외 발생");
        }
        if(checkDuplicateNumber(numbers)) {

        }
    }


}
