package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = generateNumber();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guess = Console.readLine();

                if (!isValidGuess(guess)) {
                    throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
                }

                List<Integer> guessNumbers = convertToIntegerList(guess);
                int[] score = getScore(guessNumbers, answer);
                int strike = score[0];
                int ball = score[1];

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.printf("%d볼 %d스트라이크%n", ball, strike);
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            if ("2".equals(restart)) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (!"1".equals(restart)) {
                System.out.println("잘못된 값을 입력하셨습니다.");
            }
        }
    }

    private static List<Integer> generateNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static int[] getScore(List<Integer> guess, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }

    private static boolean isValidGuess(String guess) {
        if (guess.length() != 3) {
            return false;
        }

        try {
            Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            return false;
        }

        return guess.chars().distinct().count() == 3;
    }

    private static List<Integer> convertToIntegerList(String str) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : str.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
