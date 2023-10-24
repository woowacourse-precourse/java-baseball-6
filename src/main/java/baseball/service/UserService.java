package baseball.service;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {
    static User user = new User();

    public static String readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        user.validateNumber(Console.readLine());
        return user.getNumber();
    }

    public static String readTypeNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
