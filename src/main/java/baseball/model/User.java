package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public int[] getUserNum(int size){ return parseUserNum(Console.readLine(), size); }

    public int[] parseUserNum(String userNum, int size){

        checkUserNumSize(userNum, size);

        int[] user = new int[size];

        for(int i=0;i<size;i++){
            user[i] = getNumbericValue(userNum.charAt(i));
        }

        return user;
    }

    public void checkUserNumSize(String userNum, int size){
        if(userNum.length() != size){
            throw new IllegalArgumentException();
        }
    }

    public int getNumbericValue(char ch){
        if(ch >= '1' && ch <= '9'){
            return Character.getNumericValue(ch);
        }
        throw new IllegalArgumentException();
    }
}
