package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            int a = Randoms.pickNumberInRange(1,9);
            System.out.println(a);

        }

//        while (true) {
//            System.out.println("숫자를 입력해주세요 : ");
//
//
//        }


    }
}
