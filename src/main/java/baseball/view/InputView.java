package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class InputView {

    private static final String START_NEW_GAME_NUMBER = "1";
    private static final String END_GAME_NUMBER = "2";

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine().trim();

        validateInputLength(input);
        validateInputNumber(input);

        return input;
    }

    public String inputStartNewGame() {
        System.out.println("게임을 새로 시작하려면 " + START_NEW_GAME_NUMBER + ", 종료하려면 " + END_GAME_NUMBER + "를 입력하세요.");
        String input = readLine().trim();

        validateInputNumber(input);

        return input;
    }

    private void validateInputLength(final String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    private void validateInputNumber(final String input) {
        long count = Arrays.stream(input.split(""))
                .filter(i -> i.charAt(0) < '1' || i.charAt(0) > '9')
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
