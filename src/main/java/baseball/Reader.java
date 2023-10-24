package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 입력값을 받아 검증하고,
 * <p>
 * 검증한 값을 다른 클래스에게 전달하거나
 * <p>
 * 잘못된 입력값이면 에러를 던지기 위한 클래스.
 */
public class Reader {
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요: ";

    /**
     * 타자 객체에 사용할 숫자를 입력받습니다.
     * <p>
     * 입력 형식에 맞지 않을 경우 IllegalArgumentException을 던질 수 있습니다.
     *
     * @param preference 숫자 길이, 범위를 담은 Preference 레코드
     * @return 각 자리를 담은 정수 리스트
     */
    public static List<Integer> readNumber(Preference preference) {
        System.out.print(REQUEST_NUMBER);

        String input = Console.readLine();
        int parsedInput = parseInt(input);
        validateRange(preference, parsedInput);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= preference.answerSize(); i++) {
            int eachDigit = parsedInput / (int) Math.pow(10.0, preference.answerSize() - i) % 10;
            validateDuplicates(result, eachDigit);
            validateEachRange(preference, eachDigit);
            result.add(eachDigit);
        }
        return result;
    }

    /**
     * 게임을 재시작할 것인지 입력받습니다.
     * <p>
     * 입력 형식에 맞지 않을 경우 IllegalArgumentException을 던질 수 있습니다.
     *
     * @return 재시작할 경우 true, 아닐 경우 false
     */
    public static boolean checkReplay() {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(Preference preference, int parsedInput) {
        if (parsedInput < preference.lowerBound() - 1 || parsedInput > Math.pow(10.0, preference.answerSize())) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicates(List<Integer> list, int digit) {
        if (list.contains(digit)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEachRange(Preference preference, int eachDigit) {
        if (eachDigit < preference.lowerBound() || eachDigit > preference.upperBound()) {
            throw new IllegalArgumentException();
        }
    }
}
