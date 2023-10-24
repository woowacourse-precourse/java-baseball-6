package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restart = "1";

        // 랜덤 값 자동 생성
        while (restart.equals("1")) {
            List<Integer> computer = new ArrayList<>();

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            List<Integer> userNum;

            while (true) {
                userNum = new ArrayList<>();
                int strike = 0, ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String[] input = Console.readLine().split("");

                if (input.length != 3) {
                    throw new IllegalArgumentException("3글자를 입력 하세요");
                }

                for (String s : input) {
                    if (!userNum.contains(Integer.parseInt(s))) {
                        userNum.add(Integer.parseInt(s));
                    }
                }

                if (userNum.size() != 3) {
                    throw new IllegalArgumentException("서로 다른 3글자를 입력 하세요.");
                }

                for (int i = 0; i < 3; i++) {
                    // 스트라이크
                    if (Objects.equals(computer.get(i), userNum.get(i))) {
                        strike++;
                        continue;
                    }
                    // 볼
                    if (computer.contains(userNum.get(i))) {
                        ball++;
                    }
                }


            }
        }
    }
}