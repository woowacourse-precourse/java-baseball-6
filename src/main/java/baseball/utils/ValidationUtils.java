package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    public ValidationUtils(){}
    public String validateNumbers(String inputNumbers){
        checkSize(inputNumbers);
        checkRange(inputNumbers);
        checkDuplicate(inputNumbers);
        return inputNumbers;
    }
    private void checkSize(String inputNumbers){
        if (inputNumbers.length() != 3){
            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
    }
    private void checkRange(String inputNumbers){
        if(inputNumbers.contains("0")){
            throw new IllegalArgumentException("1~9사이 숫자여야 합니다.");
        }
    }
    private void checkDuplicate(String inputNumbers){
        Set<Character> userNumberSet = new HashSet<>();
        for (int i=0;i < inputNumbers.length(); i++){
            userNumberSet.add(inputNumbers.charAt(i));
        }
        if (inputNumbers.length() != userNumberSet.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
