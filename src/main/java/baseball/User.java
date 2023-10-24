package baseball;

import baseball.io.Input;
import baseball.io.Output;
import java.util.List;

public class User {

    public List<Integer> userInput() {
        Output.printRequestUserNumberInput();
        return Input.userNumberInput();
    }

    public boolean finishOrRestart() {
        Output.printFinishOrRestart();
        String finishOrRestartInput = Input.finishOrRestartInput();

        return !finishOrRestartInput.equals("1");
    }
}
