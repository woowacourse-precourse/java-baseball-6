package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Game game = new Game();
            game.playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartChoice = Console.readLine();
            if (restartChoice.equals("1")) {

            } else if (restartChoice.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("사용자가 잘못된 값을 입력했습니다.");
            }
        }
    }
}
