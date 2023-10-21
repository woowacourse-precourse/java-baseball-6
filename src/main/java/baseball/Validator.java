package baseball;


import java.util.List;

public class Validator {

    // 컴퓨터를 통한 랜덤 야구번호를 검증해주는 메서드
    public Boolean validNumNotInList(Integer invalidNum, List<Integer>validNumList){
        return validNumList.contains(invalidNum);
    }
}