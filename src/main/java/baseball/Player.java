package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> playerNumber() {
        // player가 입력하는 값 String 형태로 저장
        String playerInput = Console.readLine();

        // 입력받은 값이 세 자리 숫자가 아니라면 IllegalArgumentException 발생시킨 후 애플리케이션 종료
        isThreeDigitNumber(playerInput);
        hasNoZero(playerInput);
        hasNoDuplicates(playerInput);
        isNumeric(playerInput);

        // 입력받은 값을 char 배열에 넣기
        char[] playerInputChar = playerInput.toCharArray();

        // char -> int 형태로 변환 후 List에 저장
        List<Integer> playerInputNumber = new ArrayList<>();
        int len = 0;
        while (len < 3) {
            playerInputNumber.add(Character.getNumericValue(playerInputChar[len]));
            len++;
        }
        return playerInputNumber;
    }

    public static void isThreeDigitNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void hasNoZero(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void hasNoDuplicates(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (digit == input.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
