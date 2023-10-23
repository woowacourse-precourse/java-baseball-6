package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean first_check = true; // 처음에는 반복문을 돌리지 않기 위해 true로 설정

        do {
            if (!first_check) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restartInput = scanner.next();
                if (!restartInput.equalsIgnoreCase("1") && !restartInput.equalsIgnoreCase("2")) {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                } else if (restartInput.equalsIgnoreCase("2")) {
                    scanner.close();
                    break;
                }
            }

            first_check = false; // 처음 실행 이후에는 사용자에게 물어보도록 false로 변경

            BaseballGame game = new BaseballGame();
            game.playGame();

        } while (true);
    }
}
