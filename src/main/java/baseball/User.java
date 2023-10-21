package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private Integer userNum;

    private String REGEXP_USER_NUM = "^[1-9]{3}$";

    public void setUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkUserNum(input);
    }

    // method only for test code
    public void setUserNum(String input) {
        checkUserNum(input);
    }

    public void checkUserNum(String input) {
        if (input.matches(REGEXP_USER_NUM)) {
            userNum = Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public Integer getUserNum() {
        return userNum;
    }
}
