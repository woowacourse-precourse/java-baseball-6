package baseball;

import java.util.Scanner;

public class Result {
    public int[] release(int strike, int ball) {
        int[] check_decision = new int[2];
        int check = 0;
        int decision = 0;
        if (strike != 3) {
            if(strike != 0) {
                System.out.print(strike + "스트라이크 ");
            }
            if (ball != 0) {
                System.out.print(ball + "볼 ");
            }

            if (strike == 0 && ball == 0) {
                System.out.print("낫싱");
            }
            System.out.println();
        }else {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            while (decision != 1 && decision != 2) {			// 재시작여부 올바른 값 받기
                decision = restart();
            }

            check = 1;
        }

        check_decision[0] = check;
        check_decision[1] = decision;

        return check_decision;
    }

    public int restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
