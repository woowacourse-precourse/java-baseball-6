package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputReaderImpl implements InputReader {


    public InputReaderImpl() {
    }

    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
