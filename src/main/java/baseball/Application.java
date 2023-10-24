package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구게임을 시작합니다.");

        // 1. 컴퓨터
        List<Integer> computerNumList = Computer.pickNumber();

        // 2. 플레이어
        while (true) {
            Player player = new Player();
            List<Integer> playerNumList = player.inputNumber();

            // 3. 점수판별
            Referee referee = new Referee();
            referee.count(computerNumList, playerNumList);
            // 4. 종료
            if (referee.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int menu = Integer.parseInt(Console.readLine());
                if (menu == 1) {
                    computerNumList = Computer.pickNumber();
                    continue;
                }
                if (menu == 2) {
                    break;
                }
                if (menu != 1 || menu != 2) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
    }
}
