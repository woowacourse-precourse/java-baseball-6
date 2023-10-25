package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    public ArrayList<Integer> readNumber(){
        ArrayList<Integer> userNumber = new ArrayList<>();

        System.out.print("숫자를 입력해 주세요 : ");
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
