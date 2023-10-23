package baseball;

import baseball.controller.Controller;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final String RESTART_FLAG = "1";

    public static void main(String[] args) {
        Application application = new Application();
        View view = new View();
        Controller controller = new Controller();

        view.printGameStart();
        List<Integer> computer_number = controller.randomNumber();
        while (true) {
            view.printUserInput();
            String str_input_number = controller.numberInput();
            int[] int_input_number = controller.stringToIntArray(str_input_number);
            controller.exceptionUserInput(int_input_number);

            int[] strike_ball = controller.checkStrikeAndBall(int_input_number, computer_number);
            view.printStrikeBall(strike_ball);

            if(strike_ball[STRIKE_INDEX] == SIZE) {
                view.printGameRestart();
                String restart_number = controller.numberInput();
                if(restart_number.equals(RESTART_FLAG)) {
                    computer_number = controller.randomNumber();
                } else {
                    break;
                }
            }
        }
    }
}
