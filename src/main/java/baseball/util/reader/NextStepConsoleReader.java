package baseball.util.reader;

import baseball.application.io.Reader;
import camp.nextstep.edu.missionutils.Console;

public class NextStepConsoleReader implements Reader {

    public String readLine() {
        return Console.readLine();
    }
}
