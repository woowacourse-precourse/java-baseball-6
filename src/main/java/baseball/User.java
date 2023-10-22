package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    int userNum;

    public User() {

    }

    public void setUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = inputUserNum();
        validateInput(input);
        this.userNum = changeToInteger(input);
    }

    public int getUserNum() {
        return userNum;
    }

    private static String inputUserNum() {
        return Console.readLine();  // java의 readLine()에 대하여 아는대로 설명하면?
    }

    private void validateInput(String input) {
        int number = changeToInteger(input);
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("서로다른 세 자리 자연수를 입력해주세요.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 숫자의 자릿수는 3자리로 입력해주세요.");
        }
    }
    private static int changeToInteger(String input) {
        try {  // java의 try-catch에 대한 개념과 예제 코드는?
            return Integer.parseInt(input);
        }
        // java의 IllegalArgumentException, NumberFormatException을 설명?
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("서로다른 세 자리 자연수를 입력해주세요.");
        }
    }
}
