package baseball.view;

import baseball.util.common.Common;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class UserInputView {
    private static final String REGEXP_ONLY_NUM = "\\d+";
    public UserInputView(){}

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String stringDigitsFromUserInput = Console.readLine();

        //널 체크 필요
        validateUserInputLength(stringDigitsFromUserInput);
        validateIsNumber(stringDigitsFromUserInput);
        validateHasDuplicateNumber(stringDigitsFromUserInput);

        return stringDigitsFromUserInput;
    }

    public String isContinueGameByUserInput(){
        String isContinueByUserInput = Console.readLine();
        validateIsNumber(isContinueByUserInput);

        return isContinueByUserInput;
    }

    private void validateUserInputLength(String stringDigitsFromUserInput) {
        if (stringDigitsFromUserInput.length() != Common.NUM_LENGTH) {
            throw new IllegalArgumentException("숫자의 길이가 " + Common.NUM_LENGTH + "와 다릅니다.");
        }
    }

    private void validateIsNumber(String stringDigitsFromUserInput){
        if(Pattern.matches(stringDigitsFromUserInput,REGEXP_ONLY_NUM)){
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력 되었습니다.");
        }
    }

    private void validateHasDuplicateNumber(String stringDigitsFromUserInput){
        Set<Character> userInputCharBySet = new HashSet<>();
        for(char userInputChar : stringDigitsFromUserInput.toCharArray()){
            userInputCharBySet.add(userInputChar);
        }
        if(userInputCharBySet.size() != stringDigitsFromUserInput.length()){
            throw new IllegalArgumentException("중복된 값이 들어갔습니다.");
        }
    }
}
