package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Scanner extends Exception {

    private final String END_NUM = "2";

    public String readLineGuessNumber() {
        String string = Console.readLine();
        guessNumberException(string);
        return string;
    }

    public boolean readLineChooseNumber() {
        String string = Console.readLine();
        endNumberException(string);
        return string.equals(END_NUM);
    }
}
