package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    public List<Integer> getInputFromUser(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();

        if (!isInputLengthIsThree(userInput) || !isInputIsNumber(userInput) || !isInputHasDifferentNumber(userInput)) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return List.of(Character.getNumericValue(userInput.charAt(0)),
                Character.getNumericValue(userInput.charAt(1)),
                Character.getNumericValue(userInput.charAt(2)));

    }
    public boolean isInputLengthIsThree(String userInput) {
        return userInput != null && userInput.length() == 3;
    }
    public boolean isInputIsNumber(String userInput){
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isInputHasDifferentNumber(String userInput) {
        if (userInput != null && userInput.length() == 3) {
            char[] digits = userInput.toCharArray();
            return digits[0] != digits[1] && digits[1] != digits[2] && digits[0] != digits[2];
        }
        return false;
    }

}
