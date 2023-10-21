package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void enterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        String number = Console.readLine();
    }
}
