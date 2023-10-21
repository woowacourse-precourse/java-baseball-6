package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerValidation {

    public static void checkNumber(String numbers){
        isCheckNumber(numbers);
        isCheckSize(numbers);
        return isCheckDuplicate(numbers);
    }

    public static void isCheckNumber(String numbers) {
        for(int i=0; i<numbers.length(); i++){
            if(!Character.isDigit(numbers.charAt(i))){
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
        }
    }
}
