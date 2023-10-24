package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Set<Integer> tempHashSet1 = new HashSet<>();

            while (tempHashSet1.size() < 3) {
                tempHashSet1.add(Randoms.pickNumberInRange(1, 9));
            }

            List<Integer> numbers = new ArrayList<>(tempHashSet1);

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.length() != 3) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);

                    if (c < '0' || c > '9') {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                }

                Set<Integer> tempHashSet2 = new LinkedHashSet<>();

                for (int i = 0; i < input.length(); i++) {
                    tempHashSet2.add(input.charAt(i) - '0');
                }

                if (tempHashSet2.size() < 3) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                List<Integer> inputNumbers = new ArrayList<>(tempHashSet2);

                int strikeCount = 0;

                for (int i = 0; i < numbers.size(); i++) {
                    if (inputNumbers.get(i).equals(numbers.get(i))) {
                        strikeCount++;
                    }
                }

                int ballCount = 0;

                for (int i = 0; i < numbers.size(); i++) {
                    for (int j = 0; j < inputNumbers.size(); j++) {
                        if (i == j) {
                            continue;
                        }

                        if (numbers.get(i).equals(inputNumbers.get(j))) {
                            ballCount++;
                        }
                    }
                }

                if (ballCount == 0 && strikeCount == 0) {
                    System.out.println("낫싱");
                }
                if (ballCount != 0) {
                    System.out.print(ballCount + "볼 ");
                }
                if (strikeCount != 0) {
                    System.out.print(strikeCount + "스트라이크");
                }
                System.out.println();

                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String lastInput = Console.readLine();

            if (lastInput.equals("1")) {
                continue;
            }
            if (lastInput.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}
