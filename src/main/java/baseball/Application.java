package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // computer
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // user
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                String input = Console.readLine();
                if (input.length() != 3) {
                    throw new IllegalArgumentException("3자리 숫자를 입력해 주세요.");
                }
                List<Integer> userNumber = new ArrayList<>();
                Set<Integer> userNumberSet = new HashSet<>();
                for (char ch : input.toCharArray()) {
                    int num = Character.getNumericValue(ch);
                    if (num < 1 || num > 9) {
                        throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
                    }
                    userNumber.add(num);
                    userNumberSet.add(num);
                }

                if (userNumber.size() != userNumberSet.size()) {
                    throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
                }

                // play game
                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    if (userNumber.get(i).equals(computer.get(i))) {
                        strike++;
                    } else if (computer.contains(userNumber.get(i))) {
                        ball++;
                    }
                }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    String result = "";
                    if (ball > 0) {
                        result += ball + "볼 ";
                    }
                    if (strike > 0) {
                        result += strike + "스트라이크";
                    }
                    System.out.println(result.trim());
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());
            if (restart != 1) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}
