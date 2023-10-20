package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View{
    @Override
    public void out(String message) {
        System.out.println(message);
    }
    @Override
    public String in() {
        return Console.readLine();
    }
}
