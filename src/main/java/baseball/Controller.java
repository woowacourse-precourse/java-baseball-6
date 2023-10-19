package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Integer command = 1;

    public static void run() {
        NumberGenerator generator = new NumberGenerator();

        InputView.greetingMsg();
        Answer answer = new Answer(generator.createAnswer());

        while (command != 2) {
            Integer response = InputView.inputGuideMsg();
        }
    }
}
