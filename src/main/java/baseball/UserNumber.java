package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String readLine = getReadLine();
        return userNumber;
    }

    public String getReadLine() {
        return Console.readLine();
    }
}
