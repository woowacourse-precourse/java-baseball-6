package baseball.controller;

import baseball.service.Computer;
import baseball.service.Player;

public class GameManager {
    private Computer computer;
    private Player player;
    private Boolean restart = true;

    public GameManager(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (this.restart) {
            computer.generateNumber();
            while (!computer.getComplete()) {
                System.out.print("숫자를 입력해주세요 : ");
                player.enterNumbers();
                System.out.println(computer.getResult(computer.getComputerNumbers(), player.getPlayerNumbers()));
            }

            this.getMenu();
        }
    }

    public void getMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int menu = player.enterMenuNumber();
        if (menu == 2) {
            this.restart = false;
        } else {
            this.restart = true;
        }
    }
}
