package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName    : controller
 * fileName       : ValidationController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class ValidationController {

    private static final String WROND_LENGTH_INPUT_MESSAGE = "숫자 세 자리를 입력해주세요.";
    private static final String WRONG_RANGE_INPUT_MESSAGE = "1 ~ 9 사이의 숫자를 입력해주세요.";
    private static final String DUPLICATE_NUMBER_INPUT_MESSAGE = "서로 다른 세자리의 숫자를 입력해주세요.";
    private static final int THREE_LENGTH = 3;
    private static final char NUMBER_START = '1';
    private static final char NUMBER_END = '9';
    public List<Integer> validate(String inputNumber) {
        if (!isTreeInput(inputNumber)) {
            throw new IllegalArgumentException(WROND_LENGTH_INPUT_MESSAGE);
        }
        else if (!isRange(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_INPUT_MESSAGE);
        }
        else if (!isDifferent(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT_MESSAGE);
        }
        return convertStringToIntList(inputNumber);
    }

    public boolean isTreeInput(String inputNumber){
        return inputNumber.length() == THREE_LENGTH;
    }

    public boolean isRange(String inputNumber){
        for(int i=0; i<inputNumber.length(); i++){
            if(inputNumber.charAt(i) < NUMBER_START || inputNumber.charAt(i) > NUMBER_END){
               return false;
            }
        }
        return true;
    }

    public boolean isDifferent(String inputNumber){
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == 3;
    }

    public List<Integer> convertStringToIntList(String inputNumber){
        List<Integer> playerNumbers = new ArrayList<Integer>();
        for(int i=0; i<inputNumber.length(); i++){
            int x = inputNumber.charAt(i) - '0';
            playerNumbers.add(x);
        }
        return playerNumbers;
    }
}
