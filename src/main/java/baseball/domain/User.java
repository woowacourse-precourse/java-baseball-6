package baseball.domain;

import baseball.util.exception.duplicateNumberException;
import baseball.util.exception.invaildInputLengthException;
import baseball.util.exception.inputOutOfRangeException;

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
        throw new inputOutOfRangeException();
    }

    public void checkException(String userNum, int size){
        checkUserNumSize(userNum,  size);
        checkDuplicateNum(userNum, size);
    }

    public void checkUserNumSize(String userNum, int size){
        if(userNum.length() != size){
            throw new invaildInputLengthException();
        }
    }

    public void checkDuplicateNum(String userNum, int size){
        Set<String> userSet = new HashSet<>(Arrays.asList(userNum.split("")));
        if(userSet.size() != size){
            throw new duplicateNumberException();
        }
    }
}
