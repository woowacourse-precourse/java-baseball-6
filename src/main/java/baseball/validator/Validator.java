package baseball.validator;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constant.*;

public class Validator {

    public static void checkEndOrRestart(String command){
        List<String> commandList;
        commandList = List.of(RESTART_GAME, STOP_GAME);
        if(!commandList.contains(command)){
            throw new IllegalArgumentException();
        }
    }

    public static void checkAllException(String number){
        checkNumberLength(number);
        checkDuplicatedNumber(number);
        checkNumberType(number);
    }

    public static void checkNumberLength(String number) {
        // 입력받은 값의 길이가 3이 아닐 경우
        if (number.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberType(String number) {
        // 1부터 9 사이의 "숫자"로 구성되지 않았을 경우
        if (!number.matches(NUM_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicatedNumber(String number) {
        List<Character> numberList = new ArrayList<>();
        // 중복된 숫자가 있을 경우
        for (Character singleNumber: number.toCharArray()) {
            throwExceptionIfDuplicated(numberList, singleNumber);
            numberList.add(singleNumber);
        }
    }

    private static void throwExceptionIfDuplicated(List<Character> numberList, Character singleNumber){
        if (numberList.contains(singleNumber)) {
            throw new IllegalArgumentException();
        }
    }
}