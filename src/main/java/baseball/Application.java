package baseball;

import baseball.Controller.Play_Controller;

public class Application {
    public static void main(String[] args) {
        Play_Controller controller = new Play_Controller();
        controller.runGame();
    }
}