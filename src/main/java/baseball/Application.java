package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do {
            BaseballGame game = BaseballGame.createBaseballGame();
            game.run();
        } while (gotoNextGame());

    }

    private static boolean gotoNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String flag = readLine();
        if (flag.equals("1")) {
            return true;
        } else if (flag.equals("2")) {
            System.out.println("게임 종료");
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
