package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userNumberStr;

    public void inputUserNumber() {
        try {
            userNumberStr = Console.readLine();
            isNotInteger(userNumberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // 게임 종료 구현
        }
    }

    public List<Integer> convertInputToList() {
        List<Integer> user = new ArrayList<>();
        int userNumber = Integer.parseInt(userNumberStr);
        user.add(userNumber / 100);                     // 100의 자리
        user.add((userNumber % 100) / 10);             // 10의 자리
        user.add(userNumber % 10);                     // 1의 자리
        return user;
    }

    public static void isNotInteger(String str) throws IllegalArgumentException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값을 입력하였습니다.");
        }
    }
}
