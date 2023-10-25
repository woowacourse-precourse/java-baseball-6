package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        PlayBaseball playBaseball = new PlayBaseball();
        boolean playAgain = true;

        System.out.print("숫자 야구 게임을 시작합니다.\n");
        while (playAgain) {
            playBaseball.playBall();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if ("1".equals(input)) {
                continue;
            } else if ("2".equals(input)) {
                playAgain = false;
            } else {
                throw new IllegalArgumentException("잘못된 입력값입니다. 애플리케이션을 종료합니다.");
            }
        }
        System.out.print("게임 종료");
    }
}
