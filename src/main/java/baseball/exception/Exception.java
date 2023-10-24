package baseball.exception;

import java.util.*;

public class Exception {

    public static void checkBasicException(String line, int numDigit) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }

        if (!line.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (line.length() != numDigit) {
            throw new IllegalArgumentException(numDigit + "자리 숫자를 입력해주세요.");
        }
    }

    public static void checkGameContinueException(String line) {
        if (!line.equals("1") && !line.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    public static void checkDuplicatedException(String line) {
        if (duplicatedLine(line)) {
            throw new IllegalArgumentException("겹치는 않는 숫자를 입력해주세요.");
        }
    }

    public static boolean duplicatedLine(String line) {
        List<String> list = new ArrayList<>(Arrays.asList(line.split("")));
        Set<String> set = new HashSet<>(list);

        if (list.size() > set.size()) {
            return true;
        }
        return false;
    }


}
