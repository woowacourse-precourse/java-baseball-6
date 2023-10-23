package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean isPlayGame = true;
        while (isPlayGame) {
            BaseballGame game = new BaseballGame();
            game.playGame();

            if (askForRestart()) {
                System.out.print("숫자를 입력해주세요 : ");
            } else {
                isPlayGame = false;
            }
        }
    }

    // 재시작 여부 확인
    private static boolean askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine().equals("1");
    }
}
