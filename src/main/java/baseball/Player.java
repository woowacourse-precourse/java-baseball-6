package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    Number number;

    public Player(){
        number=new Number();
    }

    public int[] myInput(){
        String input=Console.readLine();
        number.isValid(input);
        int[] ret=number.stringToIntArray(input);
        return ret;
    }

    public int restartOrExit(){
        String input=Console.readLine();
        number.isValidExitCode(input);
        return Integer.parseInt(input);
    }
}