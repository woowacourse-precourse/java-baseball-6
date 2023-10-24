package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputComponentImpl implements InputComponent {
    @Override
    public String getUserAnswer() {
        return Console.readLine();
    }
}
