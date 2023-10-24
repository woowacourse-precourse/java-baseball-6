package baseball;

import static baseball.Constant.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class User {
    public User() {
    }

    public String getNum() throws IllegalArgumentException {
        System.out.print(INPUT_NUMBER_MENT);
        String num = readLine();
        if (Validator.validNum(num)) {
            return num;
        }
        throw new IllegalArgumentException("유효하지않은 숫자입니다");
    }


}
