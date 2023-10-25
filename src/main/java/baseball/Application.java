package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 플레이어 생성
        Player player = new Player();

        // 게임에 참여할 플레이어 선택
        BaseballGame game = new BaseballGame(player);

        boolean isRun = true;
        while(isRun) {
            // 게임 실행
            game.run();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int num = Integer.parseInt(Console.readLine());
            if(num == 1) isRun = true;
            else if(num == 2) isRun = false;
            else throw new IllegalArgumentException("[Input] : End Input is Only 1,2");
        }

    }
}
