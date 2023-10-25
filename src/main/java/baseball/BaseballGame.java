package baseball;

import java.util.ArrayList;

public class BaseballGame {
    public void game() {
        Computer computer = new Computer();
        Player player = new Player();
        ArrayList<Integer> input;
        boolean end;
        int resume;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            System.out.print("숫자를 입력해주세요 : ");

            player.getInput(3);

            input = player.getTryNum();

            end = computer.check(input);
        } while (!end);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        player.getInput(1);

        resume = player.getNo();
        if (resume == 1) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.game();
        } // return else if resume == 2
    }
}
