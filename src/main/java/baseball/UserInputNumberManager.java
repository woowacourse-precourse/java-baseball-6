package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.enum_class.Message.INPUT_USERNUMBER_MESSAGE;

public class UserInputNumberManager implements UserNumberManager{
    private String userNumber;

    ExceptionContoller exceptionContoller = new ExceptionContoller();

    public String getUserNumber() {
        System.out.print(INPUT_USERNUMBER_MESSAGE.getMessage());
        userNumber = Console.readLine();

        exceptionContoller.notIntegerException(userNumber);
        exceptionContoller.notThreeDigitException(userNumber);
        exceptionContoller.duplicationException(userNumber);
        exceptionContoller.zeroValueException(userNumber);

        return userNumber;
    }
}