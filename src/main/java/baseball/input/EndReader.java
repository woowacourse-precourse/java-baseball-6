package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class EndReader {
    public static String read() {
        String line = Console.readLine();

        EndValidator.isValid(line);

        return line;
    }
}
