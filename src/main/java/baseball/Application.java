package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> answer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            System.out.println(answer.toString());
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (input.length() != 3) {
                    throw new IllegalArgumentException("사용자가 잘못된 값을 입력할 경우입니다.");
                }

                List<Integer> userGuess = Arrays.stream(input.split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (userGuess.equals(answer)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                String result = calculateResult(answer, userGuess);
                System.out.println(result);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartChoice = Console.readLine();
            if (restartChoice.equals("1")) {
                continue;
            } else if(restartChoice.equals("2")){
                break;
            } else {
                throw new IllegalArgumentException("사용자가 잘못된 값을 입력할 경우입니다.");
            }
        }
    }

    private static String calculateResult(List<Integer> answer, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (answer.contains(userGuess.get(i))) {
                balls++;
            }
        }

        String result = "";

        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크 ";
        }
        if (balls == 0 && strikes == 0) {
            result = "낫싱";
        }

        return result;
    }
}
