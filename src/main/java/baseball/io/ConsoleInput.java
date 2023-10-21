package baseball.io;


import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input{

    @Override
    public String getInput() {
        return Console.readLine().trim();
    }
}
