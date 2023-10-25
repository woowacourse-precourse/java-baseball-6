package baseball;

import baseball.container.ApplicationContainer;

public class Application {
    /* Variable */
    private final ApplicationContainer container = new ApplicationContainer();

    /* Public Method */
    public void boot() {
        container.getGameController().gameStart();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.boot();
    }
}
