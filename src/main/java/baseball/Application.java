package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BallList;
import baseball.utils.BallGenerator;
import baseball.view.BaseballView;

public class Application {

    public static void main(String[] args) {
        BaseballController controller = new BaseballController(
            new BallList(new BallGenerator().generate()), new BaseballView(), new BallGenerator());
        controller.playGame();
    }

}

