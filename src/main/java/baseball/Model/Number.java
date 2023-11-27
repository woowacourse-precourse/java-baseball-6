package baseball.Model;

import camp.nextstep.edu.missionutils.Console;

public class Number {

    public String[] inputNumValue() {
        String inputNum = Console.readLine();
        return inputNum.split(",");
    }
}
