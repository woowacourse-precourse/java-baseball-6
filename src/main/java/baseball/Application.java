package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        Computer computer = new Computer();
        BaseBallGame baseBallGame = new BaseBallGame(user, computer);
        baseBallGame.start();

    }
}
