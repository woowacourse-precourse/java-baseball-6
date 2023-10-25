package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static int getUserInput() {
        int userNumber;

        System.out.print("서로 다른 3자리 정수를 입력해주세요: ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            userNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (!isUniqueDigits(userNumber)) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }

    public static boolean isUniqueDigits(int num) {
        String numStr = String.valueOf(num);
        long distinctCount = numStr.chars().distinct().count();
        return distinctCount == numStr.length();
    }
}
