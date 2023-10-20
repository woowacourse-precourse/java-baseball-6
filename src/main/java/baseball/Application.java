package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {

    public static void main(String[] args) {
        BaseBallService baseBallService = new BaseBallService();
        boolean isGameOver = false;

        String answer = baseBallService.generateAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!isGameOver) {
            System.out.print("숫자를 입력해주세요: ");
            String in = Console.readLine();
            if (!baseBallService.isValidInput(in))
                throw new IllegalArgumentException();
            if (answer.equals(in)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                in = Console.readLine();
                if (in.equals("1")) {
                    answer = baseBallService.generateAnswer();
                }
                if (in.equals("2")) {
                    isGameOver = true;
                }
            } else {
                if (baseBallService.isNothing(in, answer)) {
                    System.out.print("낫싱");
                }
                int balls = baseBallService.countBalls(in, answer);
                int strikes = baseBallService.countStrikes(in, answer);
                if (balls > 0) {
                    System.out.printf("%d볼 ", balls);
                }
                if (strikes > 0) {
                    System.out.printf("%d스트라이크 ", strikes);
                }
                System.out.println("\b");
            }
        }
    }
}
