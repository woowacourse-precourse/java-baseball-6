package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int continued = 1;
        while (continued == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> numbers = new ArrayList<>();
            int k = 3;
            while (k > 0) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(number)) {
                    numbers.add(number);
                    k--;
                }
            }

            int numberOfStrike = 0;
            int numberOfBall = 0;

            while (numberOfStrike != 3 || numberOfBall != 0) {

                numberOfStrike = 0;
                numberOfBall = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String response = Console.readLine();
                List<Integer> prediction = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    if (!prediction.contains(response.charAt(i) - '0') && 1 <= response.charAt(i) - '0' && response.charAt(i) - '0' <= 10) {
                        prediction.add(response.charAt(i) - '0');
                    }
                }

                if (prediction.size() != 3 || response.length() != 3) {
                    throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                }

                for (int i = 0; i < prediction.size(); i++) {
                    if (prediction.get(i).equals(numbers.get(i))) {
                        numberOfStrike++;
                        continue;
                    }
                    if (numbers.contains(prediction.get(i))) {
                        numberOfBall++;
                    }
                }

                if (numberOfStrike == 3) {
                    System.out.println("3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                if (numberOfStrike == 0 && numberOfBall == 0) {
                    System.out.println("낫싱");
                    continue;
                }

                if (numberOfStrike == 0) {
                    System.out.printf("%d볼%n", numberOfBall);
                    continue;
                }

                if (numberOfBall == 0) {
                    System.out.printf("%d스트라이크%n", numberOfStrike);
                    continue;
                }

                System.out.printf("%d볼 %d스트라이크%n", numberOfBall, numberOfStrike);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                continued = Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }

            if (1 > continued || continued > 2) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }

    }
}
