package baseball.util;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {
    private static final int NUMBER_COUNT = 3;

    public String getUserInput() {
        System.out.print("숫자를 입력하세요: ");
        return readLine();
    }

    public void validateUserInput(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT + "자리의 숫자를 입력해주세요.");
        }

        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        if (hasDuplicateDigits(input)) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    private boolean isNumeric(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean askForReplay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String replay = readLine();
        return "1".equals(replay);
    }
}
