package baseball.view;

import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

public class View {

    public String getInput() {
        return Console.readLine();
    }

    public String getInput(String pattern) {
        String input = Console.readLine();
        if (!Validation.validInput(input, pattern)) {
            throw new IllegalArgumentException();
        }
        return input;
    }


    public void print(String name) {
        System.out.print(name);
    }

    public void println(String name) {
        System.out.println(name);
    }

}
