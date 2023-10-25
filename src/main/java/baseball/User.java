package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String userNumber;

    public void setUserNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        //3자리, 중복, 0여부 확인
        if (userNumber.matches("^(?!.*(.).*\\1)[1-9]{3}$")) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        this.userNumber = userNumber;
    }

    public String getUserNumbers() {
        return userNumber;
    }
}
