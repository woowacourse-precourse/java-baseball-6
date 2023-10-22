package baseball;

import static baseball.ComputerRandomNumber.computerRandomNumber;
import static baseball.MessageManager.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ComputerRandomNumber.computerRandomNumber();
        getStartingMessage();
        getInputMessage();
        getEndingMessage();
        getRestartOrEndMessage();
    }
}
