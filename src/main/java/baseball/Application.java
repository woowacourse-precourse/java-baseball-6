package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            ComNumber comNumber = new ComNumber();
            comNumber.pickNumbers();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                PlayerNumber playerNumber = new PlayerNumber();
                playerNumber.input();

                CompareNumbers compareNumbers = new CompareNumbers();
                String result = compareNumbers.compare(comNumber, playerNumber);
                System.out.println(result);

                if ("3스트라이크".equals(result)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playerInput = Console.readLine();
            if (!"1".equals(playerInput) && !"2".equals(playerInput)) {
                throw new IllegalArgumentException();
            }
            if ("2".equals(playerInput)) {
                break;
            }
        }
    }
}
