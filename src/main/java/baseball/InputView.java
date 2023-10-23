package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInputNumber() {
        System.out.println(Constants.NUMBER_QUESTION);
        return Console.readLine();
    }

    public static String getRestartOrFinish() {
        System.out.println(Constants.RESTART_OR_FINISH_QUESTION);
        return Console.readLine();
    }

}
