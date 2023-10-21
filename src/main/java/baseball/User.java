package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> balls = new ArrayList<>();

    public User() {
    }

    public void selectBalls() {
        String input = readLine();

        validateFormat(input);
        for (char c : input.toCharArray()) {
            int num = c - '0';

            if (balls.contains(num)) {
                throw new IllegalArgumentException("중복 숫자가 포함되었습니다.");
            }
            balls.add(num);
        }
    }

    private static void validateFormat(String input) {
        int inputLength = input.length();

        if (inputLength != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException("입력 형식이 일치하지 않습니다.");
        }
    }
}
