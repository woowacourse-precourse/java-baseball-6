package baseball;

import static baseball.Constant.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class User {
    public User() {
    }

    public String getNum(){
        System.out.print(INPUT_NUMBER_MENT);
        String num = readLine();
        if(!Validator.checkZeroNum(num)){
            throw new IllegalArgumentException(CHECK_ZERONUM_ERROR);
        }
        if(!Validator.checkLength(num)){
            throw new IllegalArgumentException(CHECK_LENGTH_ERROR);
        }
        if(!Validator.checkDuplicationNum(num)){
            throw new IllegalArgumentException(CHECK_DUPLICATE_ERROR);
        }
        return num;

    }


}
