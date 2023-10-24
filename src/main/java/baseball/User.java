package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class User {
    private static final String INPUT_NUMBER_MENT = "숫자를 입력해주세요 : ";

    public User() {
    }

    public String inputNum() {
        System.out.print(INPUT_NUMBER_MENT);
        return readLine();
    }


}
