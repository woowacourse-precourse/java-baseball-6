package baseball;

import baseball.controller.GameSet;

public class Application {
    public static void main(String[] args) {
        GameSet baseball = new GameSet();
        baseball.gameStart();
    }
}