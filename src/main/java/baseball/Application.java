package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요: ");

        UserNumber userNumber = new UserNumber();

        Compare compare = new Compare();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            compare.compareNumbers();

            if (compare.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int restart = sc.nextInt();

                if (restart == 2)
                    flag = false;
            }
        }
    }
}
