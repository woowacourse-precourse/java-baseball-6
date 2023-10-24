package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String check = "1";

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer);

            check = "3";
            do {
                int strike = 0, ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String playerString = readLine();

                String[] numbers = playerString.split("");

                if (numbers.length != 3) {
                    throw new IllegalArgumentException();
                }

                List<Integer> player = new ArrayList<>();

                for (String number : numbers) {
                    player.add(Integer.parseInt(number));
                    if (Integer.parseInt(number) == 0) {
                        throw new IllegalArgumentException();
                    }
                }

                Set<Integer> checking = new HashSet<>(player);
                if (checking.size() != player.size()) {
                    throw new IllegalArgumentException();
                }

                for (int i = 0; i < 3; i++) {
                    int j = 0;
                    while (j < 3) {
                        if (player.get(i) == computer.get(j)) {
                            if (i == j) strike++;
                            else ball++;
                            break;
                        }
                        else j++;
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }
                else if (strike == 0 && ball != 0) {
                    System.out.printf("%d볼\n", ball);
                }
                else if (strike != 0 && ball != 0) {
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                }
                else if (strike != 0 && ball == 0) {
                    System.out.printf("%d스트라이크\n", strike);
                    if (strike == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        check = readLine();
                        if (!check.equals("1") && !check.equals("2")) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            } while ("3".equals(check));
        } while ("1".equals(check));
    }
}