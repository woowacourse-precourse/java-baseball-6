package baseball.inputProcess;

import baseball.outputProcess.ComputerOutput;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    ComputerOutput computerOutput = new ComputerOutput();

    public String getInputValue() {
        computerOutput.getUserNumberMessage();
        return Console.readLine();
    }

    public String getChoiceValue() {
        computerOutput.questionMessage();
        return Console.readLine();
    }
}
