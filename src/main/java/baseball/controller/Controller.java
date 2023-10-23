package baseball.controller;

import baseball.model.Computer;
import baseball.view.View;

public class Controller {

    private final static Computer computer = new Computer();
    private final static View view = new View();
    private final static String FIN = "1";

    public void start() {
        String end;
        view.printStart();
        do {
            computer.prepareGame();
            playGame();
            end = view.inputEnd();
        } while (end.equals(FIN));
        view.closeConsole();
    }

    private void playGame() {
        String result = "";
        while (!result.contains("게임 종료")) {
            String input = view.inputNumber();
            result = computer.getResult(input);
            view.printResult(result);
        }
    }
}
