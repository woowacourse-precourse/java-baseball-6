package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            Player.playGame();
        } while (restartGame());
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerDecision = Console.readLine();
        if (playerDecision.equals("1")) {
            return true;
        }
        if (playerDecision.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("입력은 1 또는 2이어야 합니다.");
    }
}