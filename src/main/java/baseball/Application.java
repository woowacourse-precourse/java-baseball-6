package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> user = new ArrayList<>();

            String input = Console.readLine();
            for (String number : input.split("")) {
                user.add(Integer.parseInt(number));
            }

            if (user.size() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }

            if (user.get(0) < 1 || user.get(0) > 9 || user.get(1) < 1 || user.get(1) > 9 || user.get(2) < 1 || user.get(2) > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
            }

            if (user.get(0).equals(user.get(1)) || user.get(0).equals(user.get(2)) || user.get(1).equals(user.get(2))) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < computer.size(); i++) {
                if (computer.get(i).equals(user.get(i))) {
                    strike++;
                }

                if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                    ball++;
                }
            }

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = Integer.parseInt(Console.readLine());

                if (restart == 1) {
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }

                    continue;
                }

                System.out.println("게임 종료");
                break;
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }

            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }

            if (strike > 0) {
                System.out.println(strike + "스트라이크");
            }

            System.out.println();
        }
    }
}
