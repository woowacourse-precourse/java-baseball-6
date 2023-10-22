package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    User() {

    }

    public String getGameInput() {
        // 엔터 전까지 한 줄 입력 받음
        String input = Console.readLine();

        if (!isGameInputRight(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return input;
    }

    private boolean isGameInputRight(String input) {
        boolean[] used = new boolean[9];

        if (input.length() != 3)
            return false;

        for (int i = 0; i < 3; i++) {
            char tmp = input.charAt(i);
            int num = tmp - '0';

            if (!Character.isDigit(tmp))
                return false;

            if (used[num - 1])
                return false;

            used[num - 1] = true;
        }

        return true;
    }

    public void getGameEndNum() {

    }
}
