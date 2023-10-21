package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 문구 출력
        int n = 3; //숫자 자리수
        int status = 1; // 게임 시작 상태
        int random = 135; //랜덤 값 생성

        while (status == 1) {
            System.out.print("숫자를 입력해주세요 : ");
            int num = 0;

            try {
                num = Integer.parseInt(readLine());
                if (num < 111 || num > 999) { // 범위 이외의 값 입력 시 예외 처리
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                status = 2; // 게임 상태 변경
            }

            if (status == 2) { // 게임 종료
                break;
            }

            String playerNum = String.valueOf(num);
            String computerNum = String.valueOf(random);
            int[] p = new int[n];
            int[] c = new int[n];

            for(int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(String.valueOf(playerNum.charAt(i)));
                c[i] = Integer.parseInt(String.valueOf(computerNum.charAt(i)));
            }

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < c.length; j++) {
                    if (p[i] == c[j]) {
                        if (i == j) { // 같은 숫자이고 같은 자리일 시 strike
                            strike++;
                        } else {
                            ball++; // 같은 숫자이지만 다른 자리일 시 ball
                        }
                    }
                }
            }

            if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (ball > 0 && strike == 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }

            if (num == random) { // 정답일 시
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = Integer.parseInt(readLine());

                if (status == 2) {
                    break;
                } else { // 새로운 게임 시작 시 새로운 랜덤 값 생성
                    random = 589;
                }
            }

        }

    }

}
