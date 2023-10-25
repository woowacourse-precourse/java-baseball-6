package baseball;

import baseball.container.ApplicationContainer;

public class Application {
    /* Variable */
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new ApplicationContainer().getGameController().gameStart();
    }
}
