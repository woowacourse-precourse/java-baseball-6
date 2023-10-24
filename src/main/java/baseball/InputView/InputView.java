package baseball.InputView;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<Integer> getUserNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!isValidInput(input)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }

        List<Integer> user = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            user.add(digit - '0');
        }

        return user;
    }

    private static boolean isValidInput(String input) {
        return input.length() == 3 && input.matches("[1-9]+");
    }
}
