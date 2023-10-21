package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        int[] player = new int[3];
        int[] computer = new int[3];
        int flag = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        for (int i = 0; i < 3; i++) {
            computer[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(computer));

        // 1. 게임시작
        while (flag == 1) {

            System.out.print("숫자를 입력해주세요 : ");

            String tmp = scanner.next();
            for (int i = 0; i < 3; i++) {
                player[i] = tmp.charAt(i) - '0';
            }

            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer[i] == player[j] && i == j) strikeCount++;
                    else if (computer[i] == player[j]) ballCount++;
                }
            }

            if (strikeCount != 0 && ballCount == 0) System.out.println(strikeCount + "스트라이크");
            else if (strikeCount == 0 && ballCount != 0) System.out.println(ballCount + "볼");
            else if (strikeCount == 0) System.out.println("낫싱");
            else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int n = scanner.nextInt();
                if (n == 1) {
                    System.out.println("숫자 야구 게임을 시작합니다.");

                    for (int i = 0; i < 3; i++) {
                        computer[i] = (int) (Math.random() * 10);
                    }

                    System.out.println(Arrays.toString(computer));
                }
                if (n == 2) flag = 2;
            }
        }


    }
}
