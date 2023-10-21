package baseball;

import java.util.regex.Pattern;

public class GameController {

    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력값입니다.";
    private static final Pattern pattern = Pattern.compile("([1-9]{3,3})");

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        User user = new User();
        user.setUserInputNumber();

        if (user.userInputNumber.length() != 3) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        if (!pattern.matcher(user.userInputNumber).matches()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
