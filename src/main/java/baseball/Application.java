package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            List<Integer> generatedNumbers = Computer.getComputerNumbers();
            StrikeorBall checker = new StrikeorBall();

            Player player = new Player();
            StrikeorBall.Result result;

            do {
                List<Integer> playerNumbers = player.generateNumbers();
                if (playerNumbers == null) {
                    return;
                }
                result = checker.check(generatedNumbers, playerNumbers);
                System.out.println(result);
            } while (result.getStrikes() < 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        } while (isRestart());

        System.out.println("게임 종료. 감사합니다!");
    }

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
