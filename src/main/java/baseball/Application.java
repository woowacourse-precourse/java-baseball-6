package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList();
        List<Integer> user = new ArrayList();
        int number = 0;
        int strike = 0;
        int ball = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.print("숫자를 입력해주세요 : ");
            number = Integer.parseInt(Console.readLine());
            if (number > 999 || number < 111) {
                throw new IllegalArgumentException();
            }

            user.clear();
            user.add(number / 100);
            user.add(number % 100 / 10);
            user.add(number % 100 % 10);
            strike = 0;
            ball = 0;

            for(int i = 0; i < 3; ++i) {
                if (user.get(i) == computer.get(i)) {
                    ++strike;
                } else if (user.get(i) != computer.get(i) && computer.contains(user.get(i))) {
                    ++ball;
                }
            }

            if (ball > 0) {
                System.out.print("" + ball + "볼 ");
            }

            if (strike > 0) {
                System.out.print("" + strike + "스트라이크");
            }

            if (ball == 0 && strike == 0) {
                System.out.print("낫싱");
            }

            System.out.println();
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String selection = Console.readLine();
                if (selection.equals("1")) {
                    computer.clear();
                } else if (selection.equals("2")) {
                    return;
                }
            }
        }
    }
}

