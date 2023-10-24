package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            // Class(1) 컴퓨터 숫자 지정
            List<Integer> comNumbers = new ArrayList<>();
            while (comNumbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!comNumbers.contains(randomNumber)) {
                    comNumbers.add(randomNumber);
                }
            }
            // Class(1) 끝

            System.out.println("숫자 야구 게임을 시작합니다.");

            // Class(2) 게임 시작
            int ball = 0;
            int strike = 0;

            while (strike != 3) {
                ball = 0;
                strike = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String myNumbers = Console.readLine();

                for (int i = 0; i <= 2; i++) {
                    int compare = comNumbers.indexOf(myNumbers.charAt(i) - '0');

                    if (compare == -1) {
                        // 일치하는 숫자 없음
                    } else if (compare == i) {
                        ++strike;
                    } else {
                        ++ball;
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.print("낫싱");
                }
                if (ball > 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.println();
            }
            // Class(2) 끝

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // Class(3) 재시작
            int replay = Integer.parseInt(Console.readLine());
            if (replay == 1) {
                // 게임 재시작
            } else if (replay == 2) {
                break;
            } else {
                // 예외처리
            }
            // Class(3) 끝
        }
    }
}