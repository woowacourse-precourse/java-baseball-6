package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballException {

    // 중복 검사 함수
    public boolean isDuplicationExist(String randomNum) {
        ArrayList<Character> randomNumList = new ArrayList<Character>();
        for (int i=0; i<3; i++){
            randomNumList.add(randomNum.charAt(i));
        }
        Set<Character> randNumSet = new HashSet<>(randomNumList);
        if (randNumSet.size()!=3) {
            return true;
        }
        return false;
    }

    // 문자열이 모두 숫자로만 이루어져있는지 검사하는 함수
    public boolean isCharacterExist(String randomNum) {
        try{
            Integer.parseInt(randomNum);
            return false;
        } catch(NumberFormatException e){
            return true;
        }
    }

}
