package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer com = new Computer();
        User user = new User();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(com.computerNumber().toString());
        System.out.println(user.userNumber().toString());
    }
}
