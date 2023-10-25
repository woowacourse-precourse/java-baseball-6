package baseball.controller;

import baseball.view.Input;
import baseball.model.Target;
import baseball.view.Output;

public class Game {

    public void run() {
        Hint.isAnswer = false;

        Output.startMessage();

        Target target = new Target();
        int[] targetNum = target.getTargetNum();

        while (!Hint.isAnswer) {
            String userString = Input.inputUserNum();
            int[] userNum = Input.getIntegerArrayFromString(userString);

            Hint.doBaseball(userNum, targetNum);
        }

        Output.finishMessage();
    }

    public boolean isExit() {
        return Exit.isReplay();
    }
}
