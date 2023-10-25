package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import static baseball.model.TargetNum.TARGET_LENGTH;

import java.util.HashSet;

public class Input {

    public static String userGuess() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();

        if (!checkLength(userNum)) {
            throw new IllegalArgumentException("길이가 " + TARGET_LENGTH + "와(과) 다릅니다.");
        }
        else if (!checkEqual(userNum)) {
            throw new IllegalArgumentException("각 자리 숫자는 모두 다른 숫자로 이루어져야 합니다.");
        }
        else if (!checkNumericValue(userNum)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        return userNum;
    }
    public static boolean checkLength(String userNum) {
        return userNum.length() == TARGET_LENGTH;
    }

    public static boolean checkNumericValue(String userNum) {
        final String REGEX = "[0-9]+";
        return userNum.matches(REGEX);
    }

    public static boolean checkEqual(String userNum) {
        HashSet<Character> userCharSet = new HashSet<>();
        for (int i = 0; i < TARGET_LENGTH; i++) {
            userCharSet.add(userNum.charAt(i));
        }

        return userCharSet.size() == TARGET_LENGTH;
    }

    public static void consoleClose() {
        Console.close();
    }

    public static int[] stringToInt(String userNumber) {
        int[] userNum = new int[userNumber.length()];
        for (int i = 0; i < userNumber.length(); i++) {
            userNum[i] = Character.getNumericValue(userNumber.charAt(i));
        }

        return userNum;
    }

    public static String inputReplayOrEnd() {
        return Console.readLine();
    }
}