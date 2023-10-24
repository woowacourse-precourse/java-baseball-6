package baseball.service;

import baseball.domain.User;
import baseball.view.InputView;

public class UserService {
    final static User user = new User();
    final static InputView inputView = new InputView();

    public static String readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        user.validateNumber(inputView.getUserNumber());
        return user.getNumber();
    }

    public static String readTypeNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return inputView.getTypeNumber();
    }
}
