package baseball;

import baseball.controller.BaseballController;
import baseball.exception.InvalidInputException;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController controller = new BaseballController();
        try {
            controller.init();
        }catch (InvalidInputException e){
            e.printStackTrace();
        }

    }
}
