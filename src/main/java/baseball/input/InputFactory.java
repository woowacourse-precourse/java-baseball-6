package baseball.input;

import java.io.IOException;

public class InputFactory {
    public enum ConsoleType {
        //BUFFER,
        SCANNER
    }

    private static ConsoleType currentConsoleType = ConsoleType.SCANNER;

    public static void setConsoleType(ConsoleType consoleType) {
        currentConsoleType = consoleType;
    }

    public static String readLine() throws IOException {
        return switch (currentConsoleType) {
            case SCANNER -> camp.nextstep.edu.missionutils.Console.readLine();
            //case BUFFER -> Console.readLine();
        };
    }

    public static void close() {
        switch (currentConsoleType) {
            case SCANNER -> camp.nextstep.edu.missionutils.Console.close();
            //case BUFFER -> Console.close();
        }
    }
}
