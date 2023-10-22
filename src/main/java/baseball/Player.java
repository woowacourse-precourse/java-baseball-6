package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static final int INPUT_LENGTH = 3;
    private static final String RESTART_NUM = "1";
    private static final String END_NUM = "2";
    private static final String VALID_DIGIT_REGEX = "^[1-9]{3}$";

    private List<String> playerInput;
    private String endInput;

    public Player(){
    }

    public void setInput(){
        String input = Console.readLine();
        validateInput(input);
        playerInput = Arrays.asList(input.split(""));
    }

    public List<String> getInput(){
        return playerInput;
    }

    private void validateInput(String input){
        validateLength(input);
        validateOnlyNumber(input);
        validateDuplicated(input);
    }

    private void validateLength(String input){
        if(input.length() != INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(String input){
        Set<Character> existedCharacter = new HashSet<>();

        for(int i=0;i<INPUT_LENGTH;i++){
            char ch = input.charAt(i);

            if(existedCharacter.contains(ch)){
                throw new IllegalArgumentException();
            }

            existedCharacter.add(ch);
        }
    }

    private void validateOnlyNumber(String input){
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
