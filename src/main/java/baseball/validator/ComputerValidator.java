package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 컴퓨터 난수 생성 검증자
* */
public class ComputerValidator {
    
    //세 자리수 생성 검증
    public static void isNumberSizeCorrect(List<Integer> computerNumberList)throws IllegalArgumentException{
        if(computerNumberList.size() != 3){
            throw new IllegalArgumentException("잘못된 값이 생성되었습니다. 세 자리수만 생성되어야 합니다.");
        }
    }
    
    //1~9 자연수 이외의 공백, 숫자, 문자 검증
    public static void isNumberExistInRange(List<Integer> computerNumberList)throws IllegalArgumentException{
        for(Integer number : computerNumberList){
            if(number<=0 || number > 9){
                throw new IllegalArgumentException("숫자는 1~9 사이에 생성되어야 합니다.");
            }
        }
    }
    
    //중복 숫자 검증
    public static void isNumberDuplicated(List<Integer> computerNumberList) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : computerNumberList){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException("중복된 숫자가 생성되었습니다.");
            }
        }
    }
}
