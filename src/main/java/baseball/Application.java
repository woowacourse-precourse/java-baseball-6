package baseball;

import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        BaseballService game = new BaseballService();
        String endGame = "3스트라이크";

        System.out.println("숫자 야구 게임을 시작합니다.");

        int flag = 0;

        while (flag != 2) {
            String newGame = game.makeNewGame();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String tryGame = Console.readLine();

                if (!game.isValid(tryGame)) {
                    throw new IllegalArgumentException("유효하지 않은 게임 방식입니다.");
                }

                String output = game.getGameResult(tryGame, newGame);

                System.out.println(output);
                if (output.compareTo(endGame) == 0) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            flag = Integer.parseInt(Console.readLine());

            if (flag != 1 && flag != 2) {
                System.out.println("잘못된 명령어를 입력하였습니다");
                break;
            }
            if (flag == 2) {
                System.out.println("게임 종료");
            }
        }
    }
}
