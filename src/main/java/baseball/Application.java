package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // start
        System.out.println("숫자 야구 게임을 시작합니다.");
        String choice = "1"; // 반복문 시작을 위해 1로 설정

        while (choice.equals("1")) {
            // computer 생성
            Computer computer = new Computer();
            List<Integer> computerNumber = computer.getRandomNumber();

            // player 생성
            Player player = new Player();

            String result = "낫싱"; // 게임 시작 전 결과는 낫싱으로 설정

            while (!result.equals("3스트라이크")) { // 3스트라이크일 때, 게임이 종료됨
                List<Integer> playerNumber = player.setNumber();
                // 숫자 비교값을 설정
                result = computer.compareNumber(computerNumber, playerNumber);
                System.out.println(result); // 플레이어에게 결과를 보여줌
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = Console.readLine(); // 1: 반복, 2: 종료
        }
    }
}
