package baseball.domain;

import java.util.*;

public class User {

    public int[] parseUserNum(String userNum, int size){

        checkException(userNum, size);

        int[] user = new int[size];

        for(int i=0;i<size;i++){
            user[i] = getNumbericValue(userNum.charAt(i));
        }

        return user;
    }

    public int getNumbericValue(char ch){
        if(ch >= '1' && ch <= '9'){
            return Character.getNumericValue(ch);
        }
        throw new IllegalArgumentException("1-9사이의 숫자만 입력해주세요.");
    }

    public void checkException(String userNum, int size){
        checkUserNumSize(userNum,  size);
        checkDuplicateNum(userNum, size);
    }

    public void checkUserNumSize(String userNum, int size){
        if(userNum.length() != size){
            throw new IllegalArgumentException("3자리의 숫자만 입력해주세요.");
        }
    }

    public void checkDuplicateNum(String userNum, int size){
        Set<String> userSet = new HashSet<>(Arrays.asList(userNum.split("")));
        if(userSet.size() != size){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
