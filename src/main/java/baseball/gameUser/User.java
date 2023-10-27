package baseball.gameUser;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Integer> userNum;

    public User() {
        this.userNum = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            isValidInput(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public List<Integer> getUserNum() {
        return userNum;
    }

    private void isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }

        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
            }

            int num = Character.getNumericValue(c);
            if (userNum.contains(num)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
            }
            userNum.add(num);

        }
    }
}
