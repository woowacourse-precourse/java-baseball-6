package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class PlayerValidation {
    private static final String NULL_ERROR_MESSAGE = "빈문자입니다";
    private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닙니다";
    private static final String SIZE_ERROR_MESSAGE = "자리 수가 아닙니다";
    private static final String DUPLICATION_ERROR_MESSAGE = "중복된 값입니다";
    private static final String IS_NOT_INPUT_ERROR_MESSAGE = "잘못된 입력 방식입니다";
    private static final int NUMBER_SIZE = 3;
    private static final int ANSWER_NUMBER_SIZE = 1;

    public static List<Integer> checkNumber(String numbers){
        isNullNumber(numbers);
        isCheckedNumber(numbers);
        isCheckedSize(numbers, NUMBER_SIZE);
        return isDifferentNumbers(numbers);
    }

    private static void isNullNumber(String numbers) {
        if(numbers.isBlank() || numbers == null){
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    public static void isCheckedNumber(String numbers) {
        for(int i=0; i<numbers.length(); i++){
            if(!Character.isDigit(numbers.charAt(i))){
                throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public static void isCheckedSize(String numbers, int size) {
        if(numbers.length() != size){
            throw new IllegalArgumentException(size+SIZE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> isDifferentNumbers(String numbers) {
        List<Integer> number = new ArrayList<>();
        for(int i=0; i<numbers.length(); i++){
            if(number.contains((numbers.charAt(i)-'0'))){
                throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
            }
            number.add(numbers.charAt(i)-'0');
        }
        return number;
    }

    public static Integer checkAnswerNumber(String number) {
        isNullNumber(number);
        isCheckedNumber(number);
        isCheckedSize(number, ANSWER_NUMBER_SIZE);
        isCheckedOneOrTwo(number);
        return Integer.parseInt(number);
    }

    public static void isCheckedOneOrTwo(String number) {
        if(!(number.equals("1") || number.equals("2"))){
            throw new IllegalArgumentException(IS_NOT_INPUT_ERROR_MESSAGE);
        }
    }
}
