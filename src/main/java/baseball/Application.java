package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 1~9 까지 3개의 임의의 중복되지 않는 자연수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer); // 확인용
        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            String afterRegexInput = input.replaceAll("[^1-9]", "");
            Set<Character> inputSet = new HashSet<>();
            for (char c : afterRegexInput.toCharArray()) {
                inputSet.add(c);
            }
            try {

                if (inputSet.size() != 3) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }

            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == (input.charAt(i) - '0')) {
                    strike++;
                } else if (computer.contains(input.charAt(i) - '0')) {
                    ball++;
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                continue;
            } else if (strike == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            } else if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
                continue;
            } else if (ball != 0 && strike == 0) {
                System.out.println(ball + "볼");
                continue;
            } else if (ball == 0 && strike != 0) {
                System.out.println(strike + "스트라이크");
                continue;
            }


        }
    }
}
