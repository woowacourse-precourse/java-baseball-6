package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private static final int NUMBER_LENGTH = 3;
    private final Computer computer;

    public GameManager(Computer computer) {
        this.computer = computer;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            boolean isGameEnd = playerTurn(); // TODO
            if (!isGameEnd) continue;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (!isRetry(input)) break; // TODO
            computer.setNumber();
        }
    }
}
