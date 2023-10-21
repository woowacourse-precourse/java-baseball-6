package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    private static final String RESTART = "1";
//    private static final String QUIT = "2";
    private static final int TOTAL_CARDS = 3;

    public static void main(String[] args) {
        playBaseballGame();
    }

    private static void playBaseballGame() {
        List<Integer> computer = getComputerPicks();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
            validateInput(input);

            Result result = getResult(computer, input);
            printResult(result);

            computer = checkThreeStrikes(result, computer);
            if (computer == null) break;
        }
    }

    private static List<Integer> checkThreeStrikes(Result result, List<Integer> computer) {
        if (result.strikes() == computer.size()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            validateOneOrTwo(input);

            return input.equals(RESTART) ? getComputerPicks() : null;
        }
        return computer;
    }

    private static void validateOneOrTwo(String oneOrTwo) {
        if (!oneOrTwo.matches("[1-2]")) throw new IllegalArgumentException();
    }

    private static void printResult(Result result) {
        if (result.balls() == 0 && result.strikes() == 0) System.out.println("낫싱");
        else if (result.balls() == 0) System.out.println(result.strikes() + "스트라이크");
        else if (result.strikes() == 0) System.out.println(result.balls() + "볼");
        else System.out.println(result.balls() + "볼" + " " + result.strikes() + "스트라이크");
    }

    private static void validateInput(String input) {
        if (!input.matches("[1-9]{3}") || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateDigits(String input) {
        return input.chars().distinct().count() < input.length();
    }

    private static Result getResult(List<Integer> computer, String input) {
        int balls = 0;
        int strikes = 0;
        char[] inputChars = input.toCharArray();

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (computer.get(i) == Character.getNumericValue(inputChars[j])) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                    break;
                }
            }
        }

        return new Result(balls, strikes);
    }

    private record Result(int balls, int strikes) {
    }

    private static List<Integer> getComputerPicks() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < TOTAL_CARDS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
