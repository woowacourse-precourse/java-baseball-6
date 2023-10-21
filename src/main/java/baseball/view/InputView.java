package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance(){
        return instance;
    }

    public String readUserNumber() {
         return Console.readLine();
    }

    public String readRestart() {
        return Console.readLine();
    }
}
