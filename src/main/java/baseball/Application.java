package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        String isGameContinue;

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> answer = random3();
            List<Integer> playerInput;
            do {
                playerInput = player3();
                System.out.println(printResult(answer, playerInput));
            }
            while (!answer.equals(playerInput));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            isGameContinue = Console.readLine();
            if (!isGameContinue.equals("1") && !isGameContinue.equals("2")) {
                throw new IllegalArgumentException("허용되지 않은 입력입니다.");
            }
        }
        while (isGameContinue.equals("1"));

        System.out.println("게임 종료");
    }

    public static List<Integer> random3() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }

    public static List<Integer> player3() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> inputstr = Arrays.asList(Console.readLine().split(""));
        List<Integer> input = inputstr.stream().map(Integer::parseInt).toList();

        if (exceptions(input)) {
            throw new IllegalArgumentException("허용되지 않은 입력입니다.");
        }
        return input;
    }

    public static boolean exceptions(List<Integer> input) {
        if (input.size() != 3) {
            return true;
        }
        if (input.size() != input.stream().distinct().count()) {
            return true;
        }
        return false;
    }

    public static String printResult(List<Integer> answer, List<Integer> input) {
        String str = "";
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (input.contains(answer.get(i))) {
                if (input.get(i).equals(answer.get(i))) {
                    strike += 1;
                } else {
                    ball += 1;
                }
            }
        }

        if (ball + strike == 0) {
            return "낫싱";
        }
        if (ball > 0) {
            str = str.concat(ball + "볼 ");
        }
        if (strike > 0) {
            str = str.concat(strike + "스트라이크 ");
        }
        return str;
    }
}
