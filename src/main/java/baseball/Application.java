package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            Player player = new Player();
            BaseballGame game = new BaseballGame(computer, player);

            boolean isGameFinished = false;
            while (!isGameFinished) {
                System.out.print("숫자를 입력해주세요 : ");
                isGameFinished = game.play();
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if ("2".equals(choice)) {
                break;
            }
        }
    }
}
