package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playBaseballGame();
    }

    private static void playBaseballGame() {
        List<Integer> computer = getComputerPicks();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int balls = 0;
            int strikes = 0;
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
            validateInput(input);

            Result result = getResult(computer, input, strikes, balls);
    private static void validateInput(String input) {
        if (!input.matches("[1-9]{3}") || hasDuplicateDigits(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateDigits(String input) {
        return input.chars().distinct().count() < input.length();
    }

    private static Result getResult(List<Integer> computer, String input, int strikes, int balls) {
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

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
