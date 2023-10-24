package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int SIZE = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int start = 1;
        while (start == 1) {
            List<Integer> answer = createAnswer();
            int[] count = new int[2];
            while (count[1] != SIZE) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                validateUserInput(input);
                List<Integer> userInput = parseUserInput(input);
                count = checkAnswer(answer, userInput);
                printResult(count);
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            validateReset(restart);
            start = Integer.parseInt(restart);
        }
        System.out.println("게임을 종료합니다.");
    }

    private static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>(SIZE);
        while (answer.size() < SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }

    private static List<Integer> parseUserInput(String input) {
        List<Integer> userInput = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            userInput.add(Character.getNumericValue(input.charAt(i)));
        }
        return userInput;
    }

    private static int[] checkAnswer(List<Integer> answer, List<Integer> userInput) {
        int[] count = new int[2];
        for (int i = 0; i < SIZE; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                count[1]++;
                continue;
            }
            for (int j = 0; j < SIZE; j++) {
                if (i != j && answer.get(i).equals(userInput.get(j))) {
                    count[0]++;
                    break;
                }
            }
        }
        return count;
    }

    private static void printResult(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            System.out.println("낫싱");
        } else if (count[0] == 0) {
            System.out.printf("%d스트라이크%n", count[1]);
        } else if (count[1] == 0) {
            System.out.printf("%d볼%n", count[0]);
        } else {
            System.out.printf("%d볼 %d스트라이크%n", count[0], count[1]);
        }
        if (count[1] == SIZE) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", SIZE);
        }
    }

    private static void validateUserInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자가 아닌 입력값이 존재합니다.");
            }
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
                }
            }
        }
        if (input.length() != SIZE) {
            throw new IllegalArgumentException("입력값의 길이가 올바르지 않습니다.");
        }
    }

    private static void validateReset(String reset) {
        if (!reset.equals("1") && !reset.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
