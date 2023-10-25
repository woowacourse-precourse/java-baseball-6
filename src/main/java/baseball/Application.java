package baseball;

import baseball.controller.Controller;
import baseball.model.Model;
import baseball.view.inputView;
import baseball.view.outputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        inputView inputView = new inputView();
        outputView outputView = new outputView();
        Controller controller = new Controller();
        List<Integer> computer = model.makeRandomNumber();
        inputView.start();

        while (true) {
            inputView.inputText();
            String input = readLine();

            model.validateInputNumber(input);
            controller.check(computer, input);

            outputView.output(controller);

            if (controller.getStrike() == 3) {
                inputView.StrikeText();
                inputView.conditionText();
                String num = readLine();
                model.validateRetryNumber(num);
                if (num.equals(Model.exit)) {
                    break;
                } else {
                    computer = model.makeRandomNumber();
                }


            }

        }


    }

}


