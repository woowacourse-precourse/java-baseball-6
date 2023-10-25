package baseball;

import baseball.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.startGame();
    }
}
