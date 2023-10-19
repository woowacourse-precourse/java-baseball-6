package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static final int COUNT_LENGTH = 3;

    public static void main(String[] args) throws IllegalStateException {
        // TODO: 프로그램 구현

        while (true) {

            List<Integer> answer = Randoms.pickUniqueNumbersInRange(1, 9, COUNT_LENGTH);

            while (true) {
                Map<Integer, Integer> answerIndex = new HashMap<>();
                for (int i = 0; i < COUNT_LENGTH; i++) {
                    answerIndex.put(answer.get(i), i);
                }

                System.out.print("숫자를 입력해주세요: ");
                String input = Console.readLine();
                String[] split = input.split("");
                Map<Integer, Integer> userIndex = new HashMap<>();
                List<Integer> userInput = Arrays.stream(split)
                        .map(Integer::parseInt)
                        .toList();

                for (int i = 0; i < COUNT_LENGTH; i++) {
                    userIndex.put(userInput.get(i), i);
                }

                int ball = 0;
                int strike = 0;

                for (int i = 0; i < COUNT_LENGTH; i++) {
                    int value = userInput.get(i);
                    boolean isExist = answerIndex.containsKey(value);
                    boolean isRightOrder = isExist && answerIndex.get(value) == userIndex.get(value);

                    if (isExist && !isRightOrder) ball++;
                    if (isExist && isRightOrder) strike++;
                }
                StringBuilder sb = new StringBuilder();
                if (ball == 0 && strike == 0) {
                    sb.append("🔴낫싱");
                } else {
                    sb.append("🟢");
                    if (ball != 0) {
                        sb.append(ball + "볼 ");
                    }
                    if (strike != 0) {
                        sb.append(strike + "스트라이크");
                    }
                }

                System.out.println(sb.toString());

                if (strike == 3) break;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            int command = Integer.parseInt(Console.readLine());
            switch (command) {
                case 1:
                    continue;
                case 2:
                    System.exit(0);
                default:
                    throw new IllegalStateException();
            }
        }

    }

    private static void printAnswer(List<Integer> values) {
        values.stream().forEach(System.out::print);
    }


}
