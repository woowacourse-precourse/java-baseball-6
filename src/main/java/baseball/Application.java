package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        final String REGEXP_PATTERN_NUMBER = "^[1-9]{3}$";

        System.out.println("숫자 야구 게임을 시작합니다.");
        StringBuilder sb;
        List<Integer> computer = getRandomNumbers();

        while (true) {
            sb = new StringBuilder();
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!Pattern.matches(REGEXP_PATTERN_NUMBER, input)) {
                throw new IllegalArgumentException("일치하지 않는 입력 방식입니다!");
            }

            System.out.println(input);

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < computer.size(); i++) {
                int num = computer.get(i);
                int stringIndex = input.indexOf(String.valueOf(num));

                if (stringIndex == i) {
                    strike += 1;
                } else if (stringIndex > -1) {
                    ball += 1;
                }
            }

            if (ball > 0) {
                sb.append(ball).append("볼");
            }

            if (ball > 0 && strike > 0) {
                sb.append(" ");
            }

            if (strike > 0) {
                sb.append(strike).append("스트라이크");
            }

            if (sb.isEmpty()) {
                sb.append("낫싱");
            }

            System.out.println(sb);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isClose = Console.readLine();
                System.out.println(isClose);
                if (isClose.equals("2")) {
                    break;
                }

                computer = getRandomNumbers();
            }
        }
    }

    static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
