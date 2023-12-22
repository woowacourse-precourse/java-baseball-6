package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class InputServiceImpl implements InputService{

    public String readLine(){
        String line = Console.readLine();
        return line;
    }
}
