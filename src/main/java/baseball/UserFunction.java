package baseball;
import camp.nextstep.edu.missionutils.Console;

public class UserFunction {
    private String userNumber;

    public String getUserNumber(){  //유저 숫자 받기
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = Console.readLine();

        return userNumber;
    }
}