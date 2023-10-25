package baseball;

import baseball.app.Computer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        computer.init();
        computer.play();
    }
}
