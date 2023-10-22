package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 1. 임의의 세자리 숫자(정답) 생성
        String exit = null;

        do {
            List<Integer> answer = new ArrayList<>();
            while (answer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!answer.contains(randomNumber)) {
                    answer.add(randomNumber);
                }
            }
            System.out.println("answer: " + answer);

            int finalStrike = 0;

            // 2. 숫자 입력 받고 검증하기

            System.out.println("숫자 야구 게임을 시작합니다.");
            do {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.length() != 3 || !input.matches("[1-9]+")) {
                    throw new IllegalArgumentException();
                }

                List<Integer> inputList = new ArrayList<>(3);
                for (int i = 0; i < 3; i++) {
                    inputList.add(input.charAt(i) - '0');
                }

                if (inputList.stream().distinct().collect(Collectors.toList()).size() != inputList.size()) {
                    throw new IllegalArgumentException();
                }

                // 3. 스트라이크 계산
                int strike = 0;
                for (int i = 0; i < 3; i++) {
                    if (answer.get(i) == inputList.get(i)) {
                        strike++;
                    }
                }
                finalStrike = strike;

                // 4. 볼 계산
                int ball = 0;
                for (int num : inputList) {
                    if (answer.contains(num)) {
                        ball++;
                    }
                }
                ball = ball - strike;

                // 5. 출력 및 종료
                if (ball > 0 && strike > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println("낫싱");
                }
            } while (finalStrike < 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            exit = Console.readLine();
        }
        while (exit.equals("1"));
    }
}
