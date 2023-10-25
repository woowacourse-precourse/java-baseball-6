package baseball;

import baseball.controller.BaseballController;
import baseball.exception.InvalidInputException;
import baseball.service.BaseballService;

public class Application {

    public static void main(String[] args) {

        BaseballService service = new BaseballService();
        BaseballController controller = new BaseballController(service);
        controller.init();

        try {
            controller.startGame();
        }catch (InvalidInputException e){
            e.printStackTrace();
        }
    }
}
