package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    private static final Baseball baseball = new Baseball();
    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final char REPLAY_GAME = '1';
    private static final char FINISH_GAME = '2';

    public static void main(String[] args) {
        while (true) {
            baseball.runGame();
            System.out.println(REPLAY_MESSAGE);
            String input = Console.readLine();
            if (input.charAt(0) == REPLAY_GAME) {
                continue;
            } else if (input.charAt(0) == FINISH_GAME) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}