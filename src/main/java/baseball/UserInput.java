package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public static String readUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return userInput;
    }

    public static String checkUserInput(String userInput) {
        try {
            // 숫자를 입력했는지
            int t1 = Integer.parseInt(userInput);
            // 3자리 숫자인지
            if (0 > t1 || t1 > 999) {
                throw new NumberFormatException();
            }
            // 0이 포함되어있는지
            if (userInput.indexOf('0') != -1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
