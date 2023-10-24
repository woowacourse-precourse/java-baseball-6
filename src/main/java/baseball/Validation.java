package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private final Processing processing = new Processing();

    public Validation() {
    }

    public void isUserInputValidate(String inputValue){
        isValueEmpty(inputValue);
        isThreeDigit(inputValue);
        isNumber(inputValue);
        isNumberDuplicate(inputValue);
    }

    public void isNumberDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    // Null 체크
    private void isValueEmpty(String inputValue){
        if (inputValue.isEmpty()){
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
    }

    // 3자리 입력 여부
    private void isThreeDigit(String inputValue){

        if (inputValue.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
    }

    // 숫자 입력 여부
    private void isNumber(String inputValue){

        for (int i = 0; i < inputValue.length(); i++){
            char numberCheck = inputValue.charAt(i);
            if (numberCheck < 49 || numberCheck > 57){
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력해주세요.");
            }
        }
    }

    // 숫자 중복 여부
    private void isNumberDuplicate(String inputValue){

        List<Integer> numbers = processing.convertStringToInteger(inputValue);
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
