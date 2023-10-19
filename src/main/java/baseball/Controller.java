package baseball;

public class Controller {
    private static Integer command = 1;

    public static void run() {
        InputView.greetingMsg();

        while (command != 2) {
            Integer response = InputView.inputGuideMsg();
        }
    }
}
