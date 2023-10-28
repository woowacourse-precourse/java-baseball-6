package baseball.model;

import baseball.view.Input;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    public static List<Integer> makeUserNum() {
        List<Integer> user = new ArrayList<>();
        Input input = new Input();

        String InputNum = input.inputUserNumber();

        for (int i = 0; i < InputNum.length(); i++) {
            user.add(InputNum.charAt(i) - '0');
        }
        if (user.stream().distinct().count() != 3
                || InputNum.length() != 3
                || (Integer.parseInt(InputNum) < 1
                && Integer.parseInt(InputNum) > 9)) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        return user;
    }
}
