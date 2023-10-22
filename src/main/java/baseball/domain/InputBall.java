package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class InputBall {
    private final List<Integer> balls;

    public InputBall() {
        this.balls = new ArrayList<>();
    }

    public boolean validateInput(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
        if (input.length() > 3) {
            throw new IllegalArgumentException("3자리 이상 입력했습니다.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0이 포함되어 있습니다");
        }
        return true;
    }
}
