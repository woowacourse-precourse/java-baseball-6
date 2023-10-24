package baseball.presentation;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class BaseballInputResolver {
    public String inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validThreeDigitNumber(input);
        validDuplicateNumber(input);

        return input;
    }

    private void validThreeDigitNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validDuplicateNumber(String input) {
        Set<Character> number = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (number.contains(c)) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }

            number.add(c);
        }
    }

    public boolean inputIsRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        validRestartInput(input);

        return GameRestartFlag.isRestart(input);
    }

    private void validRestartInput(String input) {
        if (!GameRestartFlag.isValid(input)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    private enum GameRestartFlag {
        RESTART("1"),
        END("2");

        private final String value;

        GameRestartFlag(String value) {
            this.value = value;
        }

        public static boolean isRestart(String input) {
            return RESTART.value.equals(input);
        }

        public static boolean isValid(String value) {
            return RESTART.value.equals(value) || END.value.equals(value);
        }
    }
}
