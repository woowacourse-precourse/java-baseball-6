package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.init();
        boolean isEnd = false;
        while (!isEnd) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            game.validation(input);

            List<Integer> userNum = game.userNumber(input);
            List<Integer> computerNum = game.getComputerNum();

            String hint = game.check(computerNum, userNum);
            System.out.println(hint);

            if (game.isWin()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if (Console.readLine().equals("1")) {
                    game.init();
                } else {
                    isEnd = true;
                }
            }
        }

        System.out.println("게임 종료");
    }
}
