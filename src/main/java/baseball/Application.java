package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printStartMessage();

        int continued = 1;
        while (continued == 1) {

            List<Integer> numbers = getThreeRandomNumbers();

            int numberOfStrike = 0;
            int numberOfBall = 0;

            while (!(numberOfStrike == 3 && numberOfBall == 0)) {

                numberOfStrike = 0;
                numberOfBall = 0;

                List<Integer> prediction = receiveUserInput();

                Map<String, Integer> result = countStrikeOrBall(numbers, prediction);

                numberOfStrike = result.get("strike");
                numberOfBall = result.get("ball");

                printResultMessage(numberOfStrike, numberOfBall);

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

    private static List<Integer> receiveUserInput() {
        printInputMessage();
        String userInput = Console.readLine();
        List<Integer> prediction = validateUserInput(userInput);
        return prediction;
    }

    private static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printResultMessage(int numberOfStrike, int numberOfBall) {
        if (numberOfStrike == 3 && numberOfBall == 0) {
            System.out.println("3스트라이크\n3개 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if (numberOfStrike == 0 && numberOfBall == 0) {
            System.out.println("낫싱");
            return;
        }

        if (numberOfStrike == 0) {
            System.out.printf("%d볼%n", numberOfBall);
            return;
        }

        if (numberOfBall == 0) {
            System.out.printf("%d스트라이크%n", numberOfStrike);
            return;
        }

        System.out.printf("%d볼 %d스트라이크%n", numberOfBall, numberOfStrike);
    }

    private static Map<String, Integer> countStrikeOrBall(List<Integer> numbers, List<Integer> prediction) {
        Map<String, Integer> result = new HashMap<>();

        int numberOfStrike = 0;
        int numberOfBall = 0;

        for (int i = 0; i < prediction.size(); i++) {
            if (prediction.get(i).equals(numbers.get(i))) {
                numberOfStrike++;
                continue;
            }
            if (numbers.contains(prediction.get(i))) {
                numberOfBall++;
            }
        }

        result.put("strike", numberOfStrike);
        result.put("ball", numberOfBall);

        return result;
    }

    private static List<Integer> validateUserInput(String response) throws IllegalArgumentException {
        List<Integer> prediction = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            int nextNumber = response.charAt(i) - '0';
            if (!prediction.contains(nextNumber) && 1 <= nextNumber && nextNumber <= 9) {
                prediction.add(response.charAt(i) - '0');
            }
        }

        if (prediction.size() != 3 || response.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return prediction;
    }

    private static List<Integer> getThreeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int k = 3;
        while (k > 0) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
                k--;
            }
        }
        return numbers;
    }

    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
