package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public List<Integer> getUserInputNumbers(){
        String userInput = Console.readLine();
        validate(userInput);
        return parseUserInput(userInput);
    }

    private void validate(String userInput){
        checkIfInputNumberLengthIsThree(userInput);
        checkIfInputNumberIsNotNumberFormat(userInput);
        checkIfInputNumberIsDuplicate(userInput);
    }

    private void checkIfInputNumberLengthIsThree(String userInput){
        if(userInput.length() != 3){
            throw new IllegalArgumentException("잘못된 사용자 입력입니다. : 입력의 길이가 3이 아닙니다.");
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
    private List<Integer> parseUserInput(String userInput){
        List<Integer> userInputNumbers = new ArrayList<>();
        String[] userInputArr = userInput.split("");
        for (String s : userInputArr) {
            Integer number = Integer.parseInt(s);
            userInputNumbers.add(number);
        }
        return userInputNumbers;
    }
}
