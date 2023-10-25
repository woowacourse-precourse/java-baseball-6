package baseball.GameController;

import baseball.User.User;

public class GameController {
    void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void inputView() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    void checkInput(User user, String input) {
        if (!user.checkthreeNum(input)) {

            throw new IllegalArgumentException("3자리 숫자여야 합니다.");
        }
        if (!user.checkRange(input)) {
            throw new IllegalArgumentException("1~9사이 숫자여야 합니다.");
        }
        if (!user.checkdifferentNum(input)) {
            throw new IllegalArgumentException("서로다른 숫자여야 합니다.");
        }

    }


}
