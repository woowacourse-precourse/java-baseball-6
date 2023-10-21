package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer com = new Computer();
        User user = new User();
        Compare comp = new Compare();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            List<Integer> comNum = com.computerNumber();
            System.out.println(comNum.toString());
            List<Integer> userNum = user.userNumber();
            System.out.println(userNum.toString());
            comp.compareResult(comNum, userNum);
        }

    }
}
