package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class User {
    String userNumber;

    public User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber() {
        // 사용자에게 3자리 숫자 입력받기
        String userNumber = Console.readLine();

        // 1. 3자리가 아닌경우
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요.");
        }

        // 2. 중복된 수가 있을 경우
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < userNumber.length(); i++) {
            int number = userNumber.charAt(i) - 48;
            set.add(number);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("올바른 숫자 3가지를 입력해주세요");
        }

        // 3. 1 ~ 9 사이의 숫자만 입력
        for (int i = 0; i < userNumber.length(); i++) {
            String currentUserNumber = String.valueOf(userNumber.charAt(i) - 48);
            if (!currentUserNumber.matches("^[1-9$]")) {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요");
            }
        }

        // 3. 숫자를 입력하지 않은 경우
        this.userNumber = userNumber;
    }

}