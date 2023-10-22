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
            throw new IllegalArgumentException(size+"자리 수가 아닙니다");
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

    public static Integer checkAnswerNumber(String number) {
        isCheckNumber(number);
        isCheckSize(number, 1);
        ischeckOneOrTwo(number);
        return Integer.parseInt(number);
    }

    private static void ischeckOneOrTwo(String number) {
        if(!(number.equals("1") || number.equals("2"))){
            throw new IllegalArgumentException("잘못된 입력 방식입니다");
        }
    }
}
