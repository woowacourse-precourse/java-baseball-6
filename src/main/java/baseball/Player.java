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
    private static final String NULL_EXCEPTION = "입력이 필요합니다.";
    private static final String LENGTH_EXCEPTION = "알맞지 않은 길이의 숫자가 입력되었습니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION = "중복된 숫자가 입력되었습니다";
    private static final String INVALID_DIGIT_EXCEPTION = "1-9 외의 숫자가 입력되었습니다.";

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
        validateNotNull(input);
        validateLength(input);
        validateOnlyNumber(input);
        validateDuplicated(input);
    }

    private void validateNotNull(String input){
        if(input == null || input.equals("")){
            throw new IllegalArgumentException(NULL_EXCEPTION);
        }
    }

    private void validateLength(String input){
        if(input.length() != INPUT_LENGTH){
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    private void validateDuplicated(String input){
        Set<Character> existedCharacter = new HashSet<>();

        for(int i=0;i<INPUT_LENGTH;i++){
            char ch = input.charAt(i);

            if(existedCharacter.contains(ch)){
                throw new IllegalArgumentException(DUPLICATED_NUMBER_EXCEPTION);
            }

            existedCharacter.add(ch);
        }
    }

    private void validateOnlyNumber(String input){
        if(!input.matches(VALID_DIGIT_REGEX)){
            throw new IllegalArgumentException(INVALID_DIGIT_EXCEPTION);
        }
    }

    public void setEndInput(){
        endInput = Console.readLine();
        validateNotNull(endInput);
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
