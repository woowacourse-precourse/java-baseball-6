package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleView {
    public void alert(String message) {
        System.out.println(message);
    }

    public String input() {
        return readLine();
    }
}
