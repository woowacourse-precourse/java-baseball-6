package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayBaseball {
    public static void baseball() {
        while (true) {
            Computer computer = new Computer();
            User user = new User();
            Validator validator = new Validator();
            List<Integer> computerNumber = computer.computerNumbers();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                List<Integer> userNumber = user.userNumber();
                int[] result = validator.validate(userNumber, computerNumber);
                Umpire umpire = new Umpire();
                umpire.umpireMessage(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());
            if (choice != 1) {
                break;
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}