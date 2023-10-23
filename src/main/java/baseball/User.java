package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    String userInputNumber;

    public void setUserInputNumber() {
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        this.userInputNumber = Console.readLine();
    }

    // test method
    public void setUserInputNumber(String inputNumber) {
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        this.userInputNumber = inputNumber;
    }

}
