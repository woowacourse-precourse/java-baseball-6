package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerValidator {

    //입력값이 3자리 숫자인지 검증
    public static boolean isValidInput(String playerInput) {
        return playerInput.matches("^[0-9]{3}$");
    }
    
    //1~9사이 자연수 이외 숫자, 공백, 문자 검증
    public static void isNumberExistInRange(List<Integer> playerNumberList)throws IllegalArgumentException{
        for(Integer number : playerNumberList){
            if(number<=0 || number > 9){
                throw new IllegalArgumentException("숫자는 1~9 사이에 생성되어야 합니다.");
            }
        }
    }

    //중복 숫자 검증
    public static void isNumberDuplicated(List<Integer> playerNumberList) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : playerNumberList){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException("중복된 숫자가 생성되었습니다.");
            }
        }
    }
}
