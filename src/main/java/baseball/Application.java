package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static final String RESTART_GAME = "1";
    private static final String CLOSE_GAME = "2";

    public static void main(String[] args) {
        String replayChoose = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (RESTART_GAME.equals(replayChoose)) {
            Baseball.playBaseball();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replayChoose = Console.readLine();
            if (replayChoose.equals(RESTART_GAME)) {
                continue;
            }
            if (replayChoose.equals(CLOSE_GAME)) {
                return;
            }
            try {
                if (!replayChoose.equals(RESTART_GAME) && !replayChoose.equals(CLOSE_GAME)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;

            }
        }
    }
}
