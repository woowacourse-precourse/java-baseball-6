package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class User {
    //TODO
    // - getUserNum() 사용자 숫자 입력받는 함수
    // - parseUserNum() 문자열로 들어오는 사용자 숫자를 int Array변환하고 그 과정에서 숫자가 아닌 값이 문자열에 포함되어 있으면 exception
    // - checkUserNumSize() 문자열의 길이가 NUMSIZE와 같은지 판별

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
