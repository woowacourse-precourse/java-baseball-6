package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Integer command = 1;

    public static void run() {
        Controller controller = new Controller();

        InputView.greetingMsg();
        Answer answer = new Answer(controller.createAnswer());

        while (command != 2) {
            Integer response = InputView.inputGuideMsg();
        }
    }

    private List<Integer> createAnswer() {
        List<Integer> randNums = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randNums.add(Randoms.pickNumberInRange(1, 9));
        }

        return randNums;
    }
}
