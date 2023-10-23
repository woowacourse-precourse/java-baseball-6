package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int selection;
        do {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            while (true) {
                int ball = 0;
                int strike = 0;
                System.out.print("숫자를 입력해주세요 : ");
                String x;
                try {
                    x = Console.readLine();
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
                for (int i = 0; i < 3; i++) {
                    if (computer.get(i) == Integer.parseInt(x.substring(i, i + 1))) {
                        strike++;
                    } else if (x.contains(String.valueOf(computer.get(i)))) {
                        ball++;
                    }
                }
                if (ball == 0 & strike == 0) {
                    System.out.println("낫싱");
                } else {
                    if (ball > 0) {
                        System.out.print(ball + "볼" + ((strike > 0) ? " " : "\n"));
                    }
                    if (strike > 0) {
                        System.out.println(strike + "스트라이크");
                    }
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selection = Integer.parseInt(Console.readLine());
        } while (selection == 1);
    }

}
