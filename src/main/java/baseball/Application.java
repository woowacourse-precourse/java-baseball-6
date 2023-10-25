package baseball;

import baseball.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        componentFactory.baseballController().run();
    }
}
