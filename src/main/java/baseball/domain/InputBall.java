package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class InputBall {
    private final List<Integer> balls;
    private final int MAX_LENGTH = 3;

    public InputBall() {
        this.balls = new ArrayList<>();
    }

    public void saveInput(String input) {
        validateInput(input);
        String[] parts = input.split("");
        for (int i = 0; i < MAX_LENGTH; i++) {
            balls.add(Integer.parseInt(parts[i]));
        }
    }

    private void validateInput(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH + "자리 이상 입력했습니다.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("0이 포함되어 있습니다");
        }
    }
}
