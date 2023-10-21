package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    String userInputNumber;

    public void setUserInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        this.userInputNumber = Console.readLine();
    }

    // test method
    public void setUserInputNumber(String inputNumber) {
        System.out.println("숫자를 입력해주세요 : ");
        this.userInputNumber = inputNumber;
    }

}
