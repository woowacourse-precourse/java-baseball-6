package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String answer = generateRandomNumbers();
        boolean gameContinue = true;

        while (gameContinue) {
            System.out.println("숫자를 입력해주세요 : ");
            String guess;
            try {
                guess = Console.readLine();
                validateInput(guess);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid input!");
            }
            String result = checkGuess(answer, guess);

            if (result.equals("")) {
                System.out.println("낫싱");
            } else {
                System.out.println(result);
            }

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameContinue = askContinue();
                if (gameContinue) {
                    answer = generateRandomNumbers();
                }
            }
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
            //입력값이 null이거나 비어있는 경우
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException();
            //입력값이 3자리가 아닌 경우
        }
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException();
                //각 숫자가 1에서 9사이가 아닌 경우
            }
        }
        if (hasDuplicateCharacters(input)) {
            throw new IllegalArgumentException();
            //입력값에 중복된 숫자가 있는 경우
        }
    }

    private static boolean hasDuplicateCharacters(String str) {
        return str.length() != str.chars().distinct().count();
    }

    private static boolean askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        return "1".equals(choice);
    }

    private static String checkGuess(String answer, String guess) {
        int strike = 0, ball = 0;
        for (int i = 0; i < guess.length(); i++) {
            char current = guess.charAt(i);
            if (answer.charAt(i) == current) {
                strike++;
            } else if (answer.contains(String.valueOf(current))) {
                ball++;
            }
        }
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else {
            return (ball > 0 ? ball + "볼" : "") + (strike > 0 ? strike + "스트라이크" : "");
        }
    }

    private static String generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}