package baseball.Model;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public String[] inputNumValue() {
        String inputNum = Console.readLine();
        return inputNum.split(",");
    }
}
