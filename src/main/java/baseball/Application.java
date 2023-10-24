package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int exit = 1;
        while (exit == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            exit = game();

            if (exit != 1 && exit != 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int game() {
        // 1. 3자리 랜덤숫자 정하기
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(num)) {
                answerList.add(num);
            }
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        while (true) {
            // 2. 사용자 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();

            // 3. 사용자가 입력한 숫자의 유효성 검사
            List<Integer> userNumList = new ArrayList<>();
            // 숫자 길이 검사
            if (num.length() != 3) {
                throw new IllegalArgumentException();
            }

            // 숫자 중복성 검사
            for (String str : num.split("")) {
                int i = Integer.parseInt(str);
                if (userNumList.contains(i) || i == 0) {
                    throw new IllegalArgumentException();
                }
                userNumList.add(i);
            }
            int[] userNumArr = userNumList.stream().mapToInt(Integer::intValue).toArray();

            // 4. 비교
            int strike = 0;
            int ball = 0;
            boolean exit = true;
            for (int i = 0; i < 3; i++) {
                if (answer[i] == userNumArr[i]) {
                    strike++;
                } else {
                    if (answerList.contains(userNumArr[i])) {
                        ball++;
                    }
                    exit = false;
                }
            }

            // 5. 정답여부
            if (exit) {
                System.out.println(strike + "스트라이크");
                System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return Integer.parseInt(Console.readLine());
            } else {
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ball > 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike > 0) {
                        System.out.println(strike + "스트라이크 ");
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }
}
