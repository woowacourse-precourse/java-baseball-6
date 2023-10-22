package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int INPUT_LENGTH = 3;
    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";
    private static final String VALID_DIGIT_REGEX = "^[1-9]{3}$";

    private String input;
    private String endInput;

    public Player(){
    }

    public void setInput(){
        input = Console.readLine();
        validateInput();
    }

    public String getInput(){
        return input;
    }

    private void validateInput(){
        validateLength();
        validateOnlyNumber();
        validateDuplicated();
    }

    private void validateLength(){
        if(input.length() != INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(){
        Set<Character> existedCharacter = new HashSet<>();

        for(int i=0;i<INPUT_LENGTH;i++){
            char ch = input.charAt(i);

            if(existedCharacter.contains(ch)){
                throw new IllegalArgumentException();
            }

            existedCharacter.add(ch);
        }
    }

    private void validateOnlyNumber(){
        if(!input.matches(VALID_DIGIT_REGEX)){
            throw new IllegalArgumentException();
        }
    }

    public void setEndInput(){
        endInput = Console.readLine();
        validateEndInput();
    }

    private void validateEndInput(){
        if(!endInput.equals(RESTART_NUM) && !endInput.equals(END_NUM)){
            throw new IllegalArgumentException();
        }
    }

    public boolean isEnd(){
        return endInput.equals(END_NUM);
    }
}
