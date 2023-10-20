package baseball;

import baseball.Controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean start = true;
        while (start) {
            start = Controller.run();
        }
    }
}
