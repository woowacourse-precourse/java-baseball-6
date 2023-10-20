package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleView {
    public void alert(String message) {
        System.out.println(message);
    }

    public void request(String message) {
        System.out.print(message + " : ");
    }

    public String input() {
        return readLine();
    }
}
