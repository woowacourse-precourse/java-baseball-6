package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 기능: 사용자 공 입력 검증
    private static void validatePlayerBallInput(String number) {
        validateLength(number, 3);
        validateNumeric(number);
        validateUnique(number);
    }

    // 기능: 서로 다른 숫자로만 입력해야 한다
    private static void validateUnique(String input) {
        Set<Character> uniqueNums = new HashSet<>();
        for (int numberIdx = 0; numberIdx < input.length(); numberIdx++) {
            uniqueNums.add(input.charAt(numberIdx));
        }
        if (uniqueNums.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
        }
    }

    // 기능: 숫자만 입력해야 한다
    private static void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    // 기능: length 자릿수로 입력해야 한다
    private static void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + " 자릿수로 입력해야 합니다.");
        }
    }

    private static void printInitialGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void printHint(String hint) {
        System.out.println(hint);
    }

    private static void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
