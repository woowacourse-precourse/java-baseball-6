package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserBaseballNumber {
    private static final int BASEBALL_INPUT_NUMBER = 3;
    private final List<Integer> baseballNumberList;

    public UserBaseballNumber(String userInput){
        validateBaseballInput(userInput);
        baseballNumberList = parseUserInput(userInput);
    }
    private void validateBaseballInput(String userInput){
        checkIfInputNumberLength(userInput);
        checkIfInputNumberIsNotNumberFormat(userInput);
        checkIfInputNumberIsDuplicate(userInput);
        checkIfInputNumberContainsZero(userInput);
    }
    private void checkIfInputNumberLength(String userInput){
        if(userInput.length() != BASEBALL_INPUT_NUMBER){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 입력의 길이가 " + BASEBALL_INPUT_NUMBER + "이 아닙니다.");
        }
    }
    private void checkIfInputNumberIsNotNumberFormat(String userInput){
        try{
            Integer.parseInt(userInput);
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 숫자 형식의 입력이 아닙니다.");
        }
    }
    private void checkIfInputNumberIsDuplicate(String userInput){
        String[] userInputArr = userInput.split("");
        for(int compareIdx = 0; compareIdx < userInputArr.length; compareIdx++){
            checkDuplicate(userInputArr, compareIdx);
        }
    }
    private void checkDuplicate(String[] userInputArr, int compareIdx){
        for(int i = compareIdx + 1; i < userInputArr.length; i++){
            throwExceptionIfDuplicate(userInputArr[i], userInputArr[compareIdx]);
        }
    }
    private void throwExceptionIfDuplicate(String input, String compareInput){
        if(input.equals(compareInput)){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 중복된 숫자를 입력했습니다.");
        }
    }
    private void checkIfInputNumberContainsZero(String userInput){
        String[] userInputArr = userInput.split("");
        for (String s : userInputArr) {
            throwExceptionIfEqualsZero(s);
        }
    }
    private void throwExceptionIfEqualsZero(String input){
        if(input.equals("0")){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 입력 숫자 중 0이 포함되어 있습니다.");
        }
    }
    private List<Integer> parseUserInput(String userInput){
        List<Integer> userInputNumbers = new ArrayList<>();
        String[] userInputArr = userInput.split("");
        for (String s : userInputArr) {
            Integer number = Integer.parseInt(s);
            userInputNumbers.add(number);
        }
        return userInputNumbers;
    }

    public int size(){
        return baseballNumberList.size();
    }

    public int get(int digit){
        return baseballNumberList.get(digit);
    }

}
