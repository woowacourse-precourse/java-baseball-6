package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerValidation {

    public static List<Integer> checkNumber(String numbers){
        isCheckNumber(numbers);
        isCheckSize(numbers);
        return isCheckDuplicate(numbers);
    }
}
