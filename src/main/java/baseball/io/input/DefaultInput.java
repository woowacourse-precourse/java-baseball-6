package baseball.io.input;

import camp.nextstep.edu.missionutils.Console;

public class DefaultInput implements Input {

    @Override
    public String nextLine() {
        return Console.readLine();
    }
}
