package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
       String randomTest = computerRandomNum();
       System.out.println(randomTest);
    }

    //컴퓨터 랜덤 숫자 생성 함수
    static String computerRandomNum(){
        //중복 없이 3개의 숫자로 구성
        String num = "";
        while(num.length() <3){
            String tmp = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(!num.contains(tmp)){
                num+=tmp;
            }
        }
        return num;
    }
}