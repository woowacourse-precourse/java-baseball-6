package baseball;

import baseball.Controller.Play_controller;

public class Application {
    public static void main(String[] args) {
        Play_controller controller = new Play_controller();
        controller.run();
    }
}