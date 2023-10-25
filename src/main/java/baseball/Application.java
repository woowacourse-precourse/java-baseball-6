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

        while (true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while (true) {
                String inputNumber = InputNumber();
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    int nowNumber = inputNumber.charAt(i) - '0';
                    if (nowNumber == computer.get(i)) {
                        strike++;
                    } else if (computer.contains(nowNumber)) {
                        ball++;
                    }
                }

                if (strike != 0 && ball != 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                } else if (strike != 0) {
                    System.out.printf("%d스트라이크\n", strike);
                } else if (ball != 0) {
                    System.out.printf("%d볼\n", ball);
                } else {
                    System.out.println("낫싱");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }


            }
            int intInputNum = ReStart();
            if (intInputNum == 1) {
                continue;
            }
            if (intInputNum == 2) {
                return;
            }
        }
    }

    public static String InputNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        final String REGEX = "[0-9]+";
        if (inputNumber.length() == 3 && inputNumber.matches(REGEX)) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                set.add(inputNumber.substring(i, i + 1));
            }
            if (inputNumber.length() == set.size()) {
                return inputNumber;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int ReStart() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNum = Console.readLine();
        int intInputNum = Integer.parseInt(inputNum);
        if (intInputNum == 1 || intInputNum == 2) {
            return intInputNum;
        }
        throw new IllegalArgumentException();
    }
}
