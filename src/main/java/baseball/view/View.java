package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String getInput() {
        return Console.readLine();
    }

    public void print(String name) {
        System.out.print(name);
    }

    public void println(String name) {
        System.out.println(name);
    }

}
