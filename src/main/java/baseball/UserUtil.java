package baseball;
;
import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;

public class UserUtil {
    public String getNumber(){
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public Integer getControlNumber(){
        System.out.println(INPUT_GENERAL_NUM_MSG);
        return Integer.parseInt(Console.readLine());
    }
}
