package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {
    }

    public static List<Integer> readPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        validateBlank(playerNumber);
        return toList(playerNumber);
    }

    public static int readPlayerRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartCommand = Console.readLine();
        validateBlank(restartCommand);
        return validateInteger(restartCommand);
    }

    private static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> toList(String input) {
        return Arrays.stream(input.split(""))
                .map(InputView::validateInteger)
                .collect(Collectors.toList());
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되면 안됩니다.");
        }
    }
}
