package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userNumberStr;

    public void inputUserNumber() {
        try {
            userNumberStr = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("정수가 아닌 값을 입력하였습니다.");
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
}
