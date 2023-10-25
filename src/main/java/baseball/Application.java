package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int power = 1;  // 1: restart , 2: 종료

        while (power == 1) {
            // 컴퓨터 임의 숫자 3개 생성
            List<Integer> computer = Generate.CptGetNum();

            // 변수 초기화 부분
            int ball = 0;
            int strike = 0;

            // 게임 시작문구 출력
            System.out.println("숫자 야구 게임을 시작합니다.");

            System.out.println(computer);

            while (strike != 3) {
                ball = 0;
                strike = 0;

                // 사용자 입력
                List<Integer> user = INPUT.UserInput();

                // 비교
                int[] result = new int[2];
                Compare.List_compare(computer, user, result);
                ball = result[0];
                strike = result[1];

                // 비교결과 출력
                Print.Result_print(ball, strike);

                // 게임 재시작 or 종료 입력 받기
                power = Power.userChoice(strike, power);
            }
        }
        Console.close();
    }


}
