package baseball;
import camp.nextstep.edu.missionutils.Console;

public class UserFunction {
    private String userNumber;
    ExceptionContoller exceptionContoller = new ExceptionContoller();

    public String getUserNumber(){  //유저 숫자 받기
        System.out.print("숫자를 입력해 주세요 : ");
        userNumber = Console.readLine();

        exceptionContoller.notIntegerException(userNumber);
        exceptionContoller.notThreeDigitException(userNumber);
        exceptionContoller.reduplicationException(userNumber);
        exceptionContoller.zeroValueException(userNumber);

        return userNumber;
    }
}