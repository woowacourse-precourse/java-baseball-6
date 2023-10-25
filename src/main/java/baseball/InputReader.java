package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    private static InputReader instance;
    private InputReader() {
    }

    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    // get & return player input using readLine()
    public int getInput(){
        return Integer.parseInt(Console.readLine());
    }
}
