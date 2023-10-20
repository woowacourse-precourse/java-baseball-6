package baseball.user;

import static baseball.output.GameOutput.printRequestMessage;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String inputNumberString() {
        printRequestMessage();
        return Console.readLine();
    }

}
