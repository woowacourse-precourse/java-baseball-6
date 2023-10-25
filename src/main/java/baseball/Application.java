package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            // 컴퓨터 숫자 생성
            List<Integer> generatedNumbers = Computer.getComputerNumbers();
            StrikeorBall checker = new StrikeorBall();

            Player player = new Player();
            StrikeorBall.Result result;

            do {
                // 플레이어에게 숫자를 입력받기
                List<Integer> playerNumbers = player.generateNumbers();
                if (playerNumbers == null) {
                    return;
                }
                // 플레이어와 컴퓨터의 숫자를 비교
                result = checker.check(generatedNumbers, playerNumbers);
                System.out.println(result);
            } while (result.getStrikes() < 3); // 3스트라이크이면 반복문 종료

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        } while (isRestart()); // 재시작할지 묻는 함수.

        System.out.println("게임 종료. 감사합니다!");
    }

    // 게임을 재시작할지 묻고 재시작 or 종료하는 함수.
    private static boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        while (!"1".equals(input) && !"2".equals(input)) {
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            input = Console.readLine();
        }
        return "1".equals(input);
    }
}