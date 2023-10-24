package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateRandomNumbers();
            while (true) {
                List<Integer> playerNumbers = requestPlayerNumbers();
                String result = guess(computerNumbers, playerNumbers);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("2")) break;
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> requestPlayerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < '1' || ch > '9') throw new IllegalArgumentException();
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private static String guess(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes == 3) return "3스트라이크";
        if (strikes == 0 && balls == 0) return "낫싱";
        return balls + "볼 " + strikes + "스트라이크";
    }
}
