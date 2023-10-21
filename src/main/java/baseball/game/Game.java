package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.awt.image.ConvolveOp;

public class Game {

    private static final int restart = 1;
    private static final int end = 2;

    public static void start() {
        while (true) {
            Match match = new Match();
            match.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int flag = Integer.valueOf(Console.readLine());
            if (flag == restart) {
                continue;
            }
            if (flag == end) {
                System.out.println("게임 종료");
                break;
            }
            throw new IllegalArgumentException();
        }
    }
}
