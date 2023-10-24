package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    static String inputMsg = "숫자를 입력해주세요 : ";

    public String getInput() {
        System.out.printf(inputMsg);
        return Console.readLine();
    }
}
