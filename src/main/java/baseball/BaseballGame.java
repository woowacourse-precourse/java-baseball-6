package baseball;

import java.util.List;

public class BaseballGame {

    private final Computer computer;

    private static final String PRINT_GAME_START = "숫자 야구 게임을 시작합니다.";

    public BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public void run() {
        List<Integer> correctAnswer = computer.createCorrectAnswer();
        System.out.println(PRINT_GAME_START);
    }
}
