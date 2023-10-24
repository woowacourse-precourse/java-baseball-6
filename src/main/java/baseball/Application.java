package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        int gameReplayIf1 = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameReplayIf1 == 1) {
            GameStarter newGame = new GameStarter();
            newGame.startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameReplayIf1 = Integer.parseInt(Console.readLine());
            if ((gameReplayIf1 != 1) && (gameReplayIf1 != 2)) {
                throw new IllegalArgumentException();
            }
        }

        Console.close();
    }
}
