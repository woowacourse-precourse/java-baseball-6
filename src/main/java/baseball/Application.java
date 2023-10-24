package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseballGameService gameService = new BaseballGameService();
            GameResult result = null;

            try {
                do {
                    System.out.print("숫자를 입력해주세요 : ");
                    String input = Console.readLine();
                    result = gameService.guess(input);
                    System.out.println(result);
                } while (!result.isGameWon());

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
                String choice = Console.readLine();

                if (choice.equals("2")) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("잘못된 입력으로 인해 게임이 종료됩니다.");
                return;
            }
        }
    }
}