package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private static final int NUMBER_SIZE = 3;

    public static List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        String answer = Console.readLine().strip();

        if (answer.length() != NUMBER_SIZE || !isNumber(answer)) {
            throw new IllegalArgumentException("3개의 숫자를 연속해서 입력하세요.");
        }
        return convertToList(answer);
    }

    private static boolean isNumber(String userNumber) {
        for (char ch : userNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> convertToList(String number) {
        List<Integer> userNumber = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            userNumber.add(ch - '0');
        }
        return userNumber;
    }
}
