package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean first_check = true; // 처음에는 반복문을 돌리지 않기 위해 true로 설정

        do {
            if (!first_check) {
                System.out.print("게임을 다시 시작하시겠습니까? (Y/N): ");
                String restartInput = scanner.next();

                if (!restartInput.equalsIgnoreCase("Y") && !restartInput.equalsIgnoreCase("N")) {
                    System.out.println("잘못 입력하셨습니다.");
                } else if (restartInput.equalsIgnoreCase("N")) {
                    break; // 게임 종료
                }
            }

            first_check = false; // 처음 실행 이후에는 사용자에게 물어보도록 false로 변경

            BaseballGame game = new BaseballGame();
            game.playGame();

        } while (true);
    }
}
