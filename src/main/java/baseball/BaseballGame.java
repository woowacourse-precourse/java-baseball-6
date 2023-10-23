package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private final Computer computer;

    private static final String PRINT_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String PRINT_USER_INPUT = "숫자를 입력해주세요 :";

    public BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public void run() {
        List<Integer> correctAnswer = computer.createCorrectAnswer();
        System.out.println(PRINT_GAME_START);
        do {
            play();
        } while (restart());
    }

    private boolean restart() {

    }

    private void play() {
        System.out.println(PRINT_USER_INPUT);
        String userAnswer = Console.readLine();
    }
}
