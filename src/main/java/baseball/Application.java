package baseball;

import baseball.controller.BaseballController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballController.getInstance().gameStart();
    }
}
