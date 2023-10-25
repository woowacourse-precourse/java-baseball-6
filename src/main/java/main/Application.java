package main;

import controller.ResultController;

public class Application {
    private static final ResultController resultController = new ResultController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        resultController.game();
    }
}
