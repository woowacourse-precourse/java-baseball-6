package baseball;

import baseball.controller.BaseballGameConsole;

public class Application {
    public static void main(String[] args) {
        BaseballGameConsole game = new BaseballGameConsole();
        game.start();
    }
}