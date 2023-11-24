package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int readNumber() {
        return convert(read());
    }

    public int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String read() {
        return Console.readLine();
    }
}
