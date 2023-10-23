package baseball.controller;

import baseball.user.Computer;
import baseball.user.Player;

public class GameMaster {

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        Player player = new Player();

        while (player.isNewGame()) {
            playSingleGame(computer, player);
        }
    }

    private void playSingleGame(Computer computer, Player player) {
        computer.generateBaseballNumbers();

        while (!computer.isStrikeOut()) {
            player.inputBaseballNumbers();
            computer.printBaseballResult(player.getBaseballNumbers());
        }

        player.chooseNewGameOrExit();
    }
}
