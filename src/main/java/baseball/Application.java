package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computer = generateComputerNumbers();
            boolean isGameEnd = false;

            while (!isGameEnd) {
                String input = Console.readLine();
                if (input.equals("1")) {
                    System.out.println("게임을 새로 시작합니다.");
                    break;
                }
                if (input.equals("2")) {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
                try {
                    int userInput = Integer.parseInt(input);
                    String result = checkUserInput(userInput, computer);
                    System.out.println(result);
                    if (result.equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        isGameEnd = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
                }
            }
        }
    }

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

    private static String checkUserInput(int userInput, List<Integer> computer) {
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