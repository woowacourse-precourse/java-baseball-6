package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final User user;

    public Game() {
        computer = new Computer();
        user = new User();
    }

    public void run() {
        do {
            computer.start();
        } while (true); // TODO: 추후 재시작 관련된 함수 넣기
    }

    private boolean canRestart() {
        String input = Console.readLine();
        return Integer.parseInt(input) == 1;
    }
}
