package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static baseball.Constant.*;

public class InputValidation {

    public List<Integer> validateNum(String input){
        validateLength(input);
        List<Integer> inputNums = strToList(input);
        validateRange(inputNums);
        validateDuplication(inputNums);
        return inputNums;
    }

    private void validateLength(String input){
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    private List<Integer> strToList(String input){
        String[] strArr = input.split("");
        List<Integer> integerList = new ArrayList<>();
        for (String n : strArr) {
            try {
                Integer intValue = Integer.parseInt(n);
                integerList.add(intValue);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MSG);
            }
        }
        return integerList;
    }

    private void validateRange(List<Integer> inputNums){
        for (Integer n : inputNums){
            if (n == 0){
                throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MSG);
            }
        }
    }

    private void validateDuplication(List<Integer> inputNums){
        List<Integer> checkList = new ArrayList<>();
        for (Integer n : inputNums) {
            if (checkList.contains(n)) {
                throw new IllegalArgumentException(INPUT_DUPLICATION_EXCEPTION_MSG);
            } else {
                checkList.add(n);
            }
        }
    }

    public void validateControlNumber(Integer gameControlNum){
        if (gameControlNum != 1 && gameControlNum != 2){
            throw new IllegalArgumentException(GAME_CONTROL_NUM_EXCEPTION_MSG);
        }

    }
}
