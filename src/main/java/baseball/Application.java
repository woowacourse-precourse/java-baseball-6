package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        int playing = 1;

        while (playing == 1) {
            //랜덤 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }


            //사용자 숫자 입력(맞을 때까지 반복)
            int ans = 0;
            Scanner sc = new Scanner(System.in);

            while (ans == 0) {
                //잘못 입력 시 (IllegalArgumentException 발생)

                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> user = new ArrayList<>();
                String input = sc.next();

                for (String num : input.split("")) {
                    user.add(Integer.parseInt(num));
                }

                //숫자 비교
                //총 개수 확인
                int cnt = 0;

                for (int i = 0; i < user.size(); i++) {
                    if (computer.contains(user.get(i))) {
                        cnt += 1;
                    }
                }

                //스트라이크 개수 확인
                int strike = 0;

                for (int i = 0; i < user.size(); i++) {
                    if (computer.get(i) == user.get(i)) {
                        strike += 1;
                    }
                }

                //볼 개수 확인
                int ball = cnt - strike;

                //최종 출력

                if (cnt == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    ans = 1;
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
            //게임 재시작 여부 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Integer playAgain = sc.nextInt();
            if (playAgain == 2){
                playing = 0;
            }
        }
    }
}
