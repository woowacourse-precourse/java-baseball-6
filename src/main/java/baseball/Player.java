package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> list = new ArrayList<>();

    private void validateInput(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2)
            || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }
}
