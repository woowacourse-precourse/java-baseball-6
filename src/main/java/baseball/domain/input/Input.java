package baseball.domain.input;

import baseball.domain.computer.Computer;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final Computer computer;

    public String getExpectationNumber(){
        return Console.readLine();
    }

    public String getRestartOrNot(){
        return Console.readLine();
    }

    public Input(Computer computer) {
        this.computer = computer;
    }
}
