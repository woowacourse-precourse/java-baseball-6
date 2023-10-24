package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerValidator {

    public static void isNumberSizeCorrect(List<Integer> playerNumberList)throws IllegalArgumentException{
        if(playerNumberList.size() != 3){
            throw new IllegalArgumentException("잘못된 값이 생성되었습니다. 세 자리수만 생성되어야 합니다.");
        }
    }

    public static void isNumberExistInRange(List<Integer> playerNumberList)throws IllegalArgumentException{
        for(Integer number : playerNumberList){
            if(number<=0 || number > 9){
                throw new IllegalArgumentException("숫자는 1~9 사이에 생성되어야 합니다.");
            }
        }
    }

    public static void isNumberDuplicated(List<Integer> playerNumberList) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : playerNumberList){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException("중복된 숫자가 생성되었습니다.");
            }
        }
    }
}
