package baseball;

import camp.nextstep.edu.missionutils.Console;
import controller.BaseBallController;

import java.util.List;

public class Application {
        public static void main(String[] args) {
                BaseBallController baseBallController = new BaseBallController();
                baseBallController.gameStart();
        }



}
