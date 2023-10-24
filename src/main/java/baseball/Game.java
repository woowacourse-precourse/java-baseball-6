package baseball;

import baseball.people.Pitcher;
import baseball.people.preparation.Referee;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Pitcher pitcher = Pitcher.enter();
    private final Referee referee = Referee.enter();

    private Game() {
    }

    public static Game generate() {
        return new Game();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String input;
        do {
            matchStart(0, 0, 0);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            input = Console.readLine();
        } while (pitcher.restart(input));
        Console.close();
    }

    private void matchStart(int a, int b, int c) {
        referee.playBall(a, b, c);
        int[] pitch, judge;
        String input;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            pitch = pitcher.pitch(input);
            judge = referee.judge(pitch);
        } while (judge[1] != 3);
    }
}
