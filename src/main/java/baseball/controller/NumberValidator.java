package baseball.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidator {
    private static final String WRONG_LENGTH_MESSAGE = "숫자 세 자리를 입력해주세요.";
    private static final String WRONG_RANGE_MESSAGE = "1~9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_MESSAGE = "서로 다른 세자리의 숫자만 입력 가능합니다.";




    public List<Integer> validateData(String inputNumber){


        if(!isThreeLetter(inputNumber)){
            //3자리
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        } else if(!isInRange(inputNumber)){
            //1~9사이 숫자
            throw new IllegalArgumentException(WRONG_RANGE_MESSAGE);
        } else if (!isDifferent(inputNumber)){
            //각 다른 숫자인지
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }


        return convertStringToIntList(inputNumber);
    }


    public boolean isThreeLetter(String inputNumber){
        return inputNumber.length() == 3;
    }

    public boolean isInRange(String inputNumber){
        for (int i = 0; i < inputNumber.length(); i++){
            if(!(inputNumber.charAt(i) >= '1' && inputNumber.charAt(i) <= '9' )){
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
        List<Integer> intNumber = new ArrayList<>();
        for(int i = 0; i < inputNumber.length(); i++){
            char temp = inputNumber.charAt(i);
            int num = Character.getNumericValue(temp);
            intNumber.add(num);
        }
        return  intNumber;
    }


}
