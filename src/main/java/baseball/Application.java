package baseball;

import baseball.controller.Controller;
import baseball.model.Model;
import baseball.view.View;

public class Application {
    private static final int SIZE = 3;
    private static final int STRIKE_INDEX = 1;
    private static final String RESTART_FLAG = "1";

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller();
        Model model = new Model();

        view.printGameStart();
        model.setComputer_number(controller.randomNumber());

        while (true) {
            view.printUserInput();
            String input_str = controller.numberInput();
            int[] input_number = controller.stringToIntArray(input_str);
            model.setInput_number(input_number);
            controller.exceptionUserInput(model.getInput_number());

//            int[] strike_ball = controller.checkStrikeAndBall(model.getInput_number(), model.getComputer_number());
            controller.checkStrikeAndBall(model);
            view.printStrikeBall(model.getStrike_count(), model.getBall_count());

            if(model.getStrike_count() == SIZE) {
                view.printGameRestart();
                String restart_number = controller.numberInput();
                if(restart_number.equals(RESTART_FLAG)) {
                    model.setComputer_number(controller.randomNumber());
                } else {
                    break;
                }
            }
        }
    }
}
