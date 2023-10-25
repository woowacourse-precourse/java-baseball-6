package baseball.View;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public static String readGameNumber() {
        String input = Console.readLine();
        return input;
    }

    public static int readRetryNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
