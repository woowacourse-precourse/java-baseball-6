package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private List<Integer> computerNumList;
    private Referee referee;
    private boolean run = true;


    public void run() {
        System.out.println("숫자 야구게임을 시작합니다.");

        computerNumList = Computer.pickNumber();

        while (run) {
            Player player = new Player();
            List<Integer> playerNumList = player.inputNumber();

            referee = new Referee();
            referee.count(computerNumList, playerNumList);

            exit();
        }
    }

    private void exit() {
        if (referee.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selectMenu();
        }
    }

    private void selectMenu() {
        int menu = Integer.parseInt(Console.readLine());
        if (menu == 1) {
            computerNumList = Computer.pickNumber();
        }
        if (menu == 2) {
            run = false;
        }
        if (menu != 1 && menu != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
