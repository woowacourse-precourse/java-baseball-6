package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("숫자를 입력해주세요: ");
            UserNumber userNumber = new UserNumber(); // 각 라운드마다 새로운 입력 받기
            List<Integer> userNumbers = userNumber.getUserNumbers();
            Computer computer = new Computer();
            List<Integer> computerNumbers = computer.getComputerNumbers();

            Compare compare = new Compare();
            compare.countBall(computerNumbers, userNumbers);

            if (compare.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // 1 or 2가 아닌경우 IllegalArgumentException
                try {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                    int restart = sc.nextInt();
                    if (restart == 2) {
                        flag = false;
                    } else if(restart != 1) {
                        throw new IllegalArgumentException("");
                    }
                } catch (IllegalArgumentException e) {
                    System.exit(1);
                }

            }
        }
    }
}
