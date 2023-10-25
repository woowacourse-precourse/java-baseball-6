package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameEnd = false;

        while (!isGameEnd) {
            List<Integer> computer;
            try {
                computer = generateComputerNumbers();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                continue;
            }

            boolean isRoundEnd = false;

            while (!isRoundEnd) {
                try {
                    System.out.print("숫자를 입력해주세요 : ");
                    String input = Console.readLine();
                    if (input.equals("1")) {
                        System.out.println("게임을 새로 시작합니다.");
                        isRoundEnd = true;
                    } else if (input.equals("2")) {
                        System.out.println("게임을 종료합니다.");
                        isRoundEnd = true;
                        isGameEnd = true;
                    } else {
                        validateInput(input);
                        int userInput = Integer.parseInt(input);
                        String result = calculateResult(userInput, computer);
                        System.out.println(result);
                        if (result.equals("3스트라이크")) {
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            isRoundEnd = true;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        Set<Integer> generatedNumbers = new HashSet<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (generatedNumbers.add(randomNumber)) {
                computer.add(randomNumber);
            }
            if (generatedNumbers.size() == 9) {
                throw new IllegalStateException("컴퓨터 숫자 생성에 실패했습니다.");
            }
        }
        return computer;
    }

    private static void validateInput(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+") || input.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
        }
        Set<Character> set = new HashSet<>();
        for (char ch : input.toCharArray()) {
            set.add(ch);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    private static String calculateResult(int userInput, List<Integer> computer) {
        List<Integer> userDigits = convertToDigits(userInput);
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userDigits.get(i))) {
                strikeCount++;
            } else if (computer.contains(userDigits.get(i))) {
                ballCount++;
            }
        }

        if (strikeCount > 0 && ballCount > 0) {
            return strikeCount + "스트라이크 " + ballCount + "볼";
        } else if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        } else if (ballCount > 0) {
            return ballCount + "볼";
        } else {
            return "낫싱";
        }
    }

    private static List<Integer> convertToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }
}
