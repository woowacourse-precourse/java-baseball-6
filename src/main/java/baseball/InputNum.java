package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputNum {
    public String getInputNum(){
        String inputNum = Console.readLine();

        if (inputNum.length() != 3) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
