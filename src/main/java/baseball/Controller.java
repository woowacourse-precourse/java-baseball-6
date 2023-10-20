package baseball;

import java.util.List;

public class Controller {
    private static Integer command = 1;

    public static void run() {
        NumberGenerator generator = new NumberGenerator();

        InputView inputView = new InputView();
        inputView.greetingMsg();

        Answer answer = generator.createAnswer();

        while (command != 2) {
            try {
                inputView.inputGuideMsg();
                List<Integer> input = inputView.inputByConsole();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
