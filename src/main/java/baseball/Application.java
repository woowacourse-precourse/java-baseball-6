package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.RandomNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        computer.init();
        computer.play();
    }
}
