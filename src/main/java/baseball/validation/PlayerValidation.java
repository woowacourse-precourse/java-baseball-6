package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerValidation {

    public static List<Integer> checkNumber(String numbers){
        isCheckNumber(numbers);
        isCheckSize(numbers,3);
        return isCheckDuplicate(numbers);
    }

    public static void isCheckNumber(String numbers) {
        for(int i=0; i<numbers.length(); i++){
            if(!Character.isDigit(numbers.charAt(i))){
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
        }
    }

    public static void isCheckSize(String numbers, int size) {
        if(numbers.length() != size){
            throw new IllegalArgumentException("3자리 수가 아닙니다");
        }
    }

    public static List<Integer> isCheckDuplicate(String numbers) {
        List<Integer> number = new ArrayList<>();
        for(int i=0; i<numbers.length(); i++){
            if(number.contains((numbers.charAt(i)-'0'))){
                throw new IllegalArgumentException("중복된 값입니다");
            }
            number.add(numbers.charAt(i)-'0');
        }
        return number;
    }
}
