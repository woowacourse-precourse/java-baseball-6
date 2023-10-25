package baseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userans = "";
        int restart;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String answer = "";

            //변수 생성
            while (true) {
                int a = (int) (Math.random() * 10);
                if (a == 0) {
                    continue;
                }
                answer += Integer.toString(a);
                if (answer.length() == 3) {
                    break;
                }
            }
            //입력
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                int strike = 0;
                int ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                userans = sc.nextLine();
                try {
                    if (userans.length() != 3) {
                        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                    }
                } catch (Exception e1) {
                    System.exit(0);
                }
                System.out.println("정답 : " + answer);
                //답과 비교
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (userans.charAt(i) == answer.charAt(j)) {
                            if (i == j) strike++;
                            else ball++;
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(sc.nextLine());
            if (restart == 2) {

                System.out.println("프로그램 종료");
                break;
            }

        }
    }
}
