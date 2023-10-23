package baseball;

import baseball.io.OutPut;
import baseball.io.ConsoleOutput;
import java.io.IOException;

public class Application {
    private static final OutPut output = new ConsoleOutput();
    private static final BaseBallApp baseBallApp = new BaseBallApp(output);

    public static void main(String[] args) {
        try {
            baseBallApp.run();
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("IOExcption 발생 : %s", e.getMessage()));
        }
    }
}
