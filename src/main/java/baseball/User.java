package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String EXCEPTION_MESSAGE = "잘못된 입력값입니다.";
    private Integer userNum;
    private String REGEXP_USER_NUM = "^[1-9]{3}$";

    public void setUserNum() {
        System.out.print(OUTPUT_ENTER_NUMBER);
        String input = Console.readLine();
        checkUserNum(input);
    }

    // method only for test code
    public void setUserNum(String input) {
        checkUserNum(input);
    }

    public void checkUserNum(String input) {
        boolean isDifferentDigit1 = input.charAt(0) != input.charAt(1);
        boolean isDifferentDigit2 = input.charAt(0) != input.charAt(2);
        boolean isDifferentDigit3 = input.charAt(1) != input.charAt(2);
        if (input.matches(REGEXP_USER_NUM)
                && isDifferentDigit1
                && isDifferentDigit2
                && isDifferentDigit3) {
            userNum = Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public Integer getUserNum() {
        return userNum;
    }
}
