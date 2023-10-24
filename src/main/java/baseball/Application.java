package baseball;

import baseball.controller.Controller;
import baseball.model.Model;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller();
        Model model = new Model();

        view.printGameStart();
        model.setComputer_number(controller.randomNumber());

        while (true) {
            String input_str = controller.numberInput();
            int[] input_number = controller.stringToIntArray(input_str);

            model.setInput_number(input_number);
            controller.exceptionUserInput(model.getInput_number());
            controller.checkStrikeAndBall(model);

            if (controller.checkRestart(controller, model)) break;
        }
    }
}
