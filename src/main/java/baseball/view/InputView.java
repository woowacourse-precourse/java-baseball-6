package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class InputView {
    public String inputNumbers() {
        String input = readLine();

        validateInputLength(input);
        validateInputNumber(input);

        return input;
    }

    public String inputStartNewGame() {
        String input = readLine().trim();

        validateInputStartNewGame(input);

        return input;
    }

    private void validateInputLength(final String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    private void validateInputNumber(final String input) {
        long count = Arrays.stream(input.split(""))
                .filter(i -> i.charAt(0) < 80 || i.charAt(0) > 89)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateInputStartNewGame(final String input) {
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException("게임 재시작 여부는 숫자 1, 2만 입력 가능합니다.");
        }
    }
}
