package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            GameController game = new GameController();
            game.startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // 종료 기능
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int nextGame = Integer.parseInt(Console.readLine());
            if (nextGame == 2) {
                break;
            } else if (nextGame != 1) {
                throw new IllegalArgumentException("입력 오류");
            }
        }
    }

}
