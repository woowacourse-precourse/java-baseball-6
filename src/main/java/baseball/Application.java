package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // generateComputerNumbers 메서드 추가
    private static List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // validateInput 메서드 추가
    private static void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    // convertInputToList 메서드 추가
    private static List<Integer> convertInputToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    // checkNumbers 메서드 추가
    private static String checkNumbers(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes++;
                continue;
            }
            if (computer.contains(user.get(i))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        if (strikes == 3) {
            return "3스트라이크";
        }

        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(balls).append("볼 ");
        }
        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }

        return result.toString().trim();
    }
}
