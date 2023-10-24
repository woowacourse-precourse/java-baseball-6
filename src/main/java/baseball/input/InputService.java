package baseball.input;

import camp.nextstep.edu.missionutils.Console;
public class InputService {
    public static String readLine() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
