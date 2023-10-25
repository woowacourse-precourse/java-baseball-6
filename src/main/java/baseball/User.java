package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userNumberStr;

    public void inputUserNumber(String userNumberStr) {
        try {
            userNumberStr = Console.readLine();
            isNotInteger(userNumberStr);
            isNotThreeLength(userNumberStr);
            hasDuplicateDigits(userNumberStr);
            this.userNumberStr = userNumberStr;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void convertInputToList(List<Integer> user) {
        int userNumber = Integer.parseInt(userNumberStr);
        user.add(userNumber / 100);                     // 100의 자리
        user.add((userNumber % 100) / 10);             // 10의 자리
        user.add(userNumber % 10);                     // 1의 자리
    }

    public List<Integer> getUsetNumberList() {
        List<Integer> user = new ArrayList<>();
        inputUserNumber(new String());
        convertInputToList(user);

        return user;
    }

    public static void isNotInteger(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값을 입력하였습니다.");
        }
    }

    public static void isNotThreeLength(String str) throws IllegalArgumentException {
        if (str.length() != 3) {
            throw new IllegalArgumentException("3자리 이상 혹은 이하의 값을 입력하였습니다.");
        }
    }

    public static void hasDuplicateDigits(String str) throws IllegalArgumentException {
        char[] digits = str.toCharArray();
        if (digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2]) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다. 서로 다른 숫자 3개여야 합니다.");
        }
    }
}
