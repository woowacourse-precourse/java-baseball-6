package baseball;

public class Controller {
    private static Integer command = 1;

    public static void run() {
        NumberGenerator generator = new NumberGenerator();

        InputView inputView = new InputView();
        inputView.greetingMsg();

        Answer answer = new Answer(generator.createAnswer());

        while (command != 2) {
            try {
                Integer response = inputView.inputGuideMsg();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
