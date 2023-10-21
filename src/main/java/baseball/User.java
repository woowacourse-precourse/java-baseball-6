package baseball;

import camp.nextstep.edu.missionutils.Console;


public class User {
    User() {}
    public static String UserInput() {
        System.out.print("숫자를 입력해주세요: ");

        String usrInput = Console.readLine();
        int size = usrInput.length();

        if(size != 3) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }


        return usrInput;
    }
}
