package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    private static List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(num)) {
                answer.add(num);
                System.out.println(num);
            }

        }

        return answer;
    }

    private static int[] compareInputWithAnswer(List<Integer> answer, int inputNum) {
        int ball = 0;
        int strike = 0;

        int first = inputNum / 100;
        int second = inputNum % 100 / 10;
        int third = inputNum % 10;

        if (answer.contains(first)) {
            if (answer.indexOf(first) == 0) strike++;
            else ball++;
        }
        if (answer.contains(second)) {
            if (answer.indexOf(second) == 1) strike++;
            else ball++;
        }
        if (answer.contains(third)) {
            if (answer.indexOf(third) == 2) strike++;
            else ball++;
        }

        int[] compareResult = {ball, strike};

        return compareResult;
    }

    private static void startGame() throws IllegalArgumentException{
        List<Integer> answer = makeAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            try {
                int inputNum = Integer.parseInt(input);
                int[] result = compareInputWithAnswer(answer, inputNum);
                if (input.length() > 3)
                    throw new IllegalArgumentException("over 3");

                if (result[0] == 0 && result[1] == 0) System.out.println("낫싱");
                else if (result[0] == 0) System.out.println(result[1] + "스트라이크");
                else if (result[1] == 0) System.out.println(result[0] + "볼");
                else System.out.println(result[0] + "볼 " + result[1] + "스트라이크");

                if (result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equals("over 3"))
                    throw new IllegalArgumentException("잘못된 입력값입니다. 입력값은 3자리 숫자여야 합니다.\n 입력값: \"" + input + "\"");
                throw new IllegalArgumentException("잘못된 입력값입니다. 입력값은 숫자여야 합니다.\n 입력값: \"" + input + "\"");
            }
        }
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String restartCheck = Console.readLine();
        if (restartCheck.equals("1")) return true;
        else if (restartCheck.equals("2")) return false;
        else throw new IllegalArgumentException("잘못된 입력값입니다. 입력값은 1과 2 중에 있어야 합니다.\n 입력값: \"" + restartCheck + "\"");
    }

    public static void main(String[] args) {
        try {
            boolean restart = true;
            while (restart) {
                startGame();
                restart = restartGame();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
