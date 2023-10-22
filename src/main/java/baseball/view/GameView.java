package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameView {
    private static final String NUMBER_INPUT_MSG = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MSG = "볼";
    private static final String STRIKE_MSG = "스트라이크";
    private static final String NOTHING_MSG = "낫싱";

    public String inputUserNumber() {
        System.out.print(NUMBER_INPUT_MSG);
        return Console.readLine();
    }

    public String inputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void printHint(List<Integer> result) {
        if (!result.get(1).equals(0)) {
            System.out.print(result.get(1) + BALL_MSG + ' ');
        }
        if (!result.get(0).equals(0)) {
            System.out.print(result.get(0) + STRIKE_MSG);
        }
        if (result.get(0).equals(0) && result.get(1).equals(0)) {
            System.out.print(NOTHING_MSG);
        }
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println(GAME_END_MSG);
    }
}
