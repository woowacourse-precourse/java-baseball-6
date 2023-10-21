package baseball;


import java.util.List;

public class Validator {

    // 컴퓨터를 통한 랜덤 야구번호를 검증해주는 메서드
    public Boolean validNumNotInList(Integer invalidNum, List<Integer>validNumList){
        return validNumList.contains(invalidNum);
    }

    // 사용자가 입력한 숫자가 3자리 숫자인지 확인해주는 메서드
    public Boolean validNumsLength(String invalidNums){
        if(invalidNums.length()!=3){
            throw new IllegalArgumentException("입력된 숫자가 3자리 숫자가 아닙니다.");
        }
        return Boolean.TRUE;
    }
}