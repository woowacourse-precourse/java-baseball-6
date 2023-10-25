package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    Message message = new Message();
    public ArrayList<Integer> readNumber(){
        ArrayList<Integer> userNumber = new ArrayList<>();
        //사용자(사람)으로 부터 입력 받기
        message.inputNumberMessage();
        String readNumber = Console.readLine();
        //3자리 수 인지 확인.
        if(readNumber.length()!=3){
            throw new IllegalArgumentException();
        }
        //범위 : 1~9까지. 문자->숫자 변환.
        for (int i=0; i<3; i++){
            if(readNumber.charAt(i)<'1' || readNumber.charAt(i)>'9'){
                throw new IllegalArgumentException();
            }
            userNumber.add(readNumber.charAt(i)-'0');
        }
        return userNumber;
    }
}
