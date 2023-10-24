package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserFunc {

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean isValid(String input) {
        if (input.length() != 3) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }

        return input.charAt(0) != input.charAt(1) &&
                input.charAt(0) != input.charAt(2) &&
                input.charAt(1) != input.charAt(2);
    }
}
