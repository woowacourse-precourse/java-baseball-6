package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int LENGTH_OF_NUMBER = 3;
    private static final String ENTER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String EXCEPTION_MESSAGE = "1부터 9까지 서로 다른 숫자를 입력해주세요.";
    public static int userNumber;

    public void setUserNumber() {
        System.out.print(ENTER_MESSAGE);
        String input = inputUserNumber();
        validateInput(input);
        this.userNumber = Integer.parseInt(input);
    }


    public int getUserNumber() {
        return userNumber;
    }

    private static String inputUserNumber() {
        return Console.readLine();
    }


    private void validateInput(String input) {

        if (input.length() != LENGTH_OF_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
            }
        }


    }
}