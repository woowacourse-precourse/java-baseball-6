package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean continuePlaying = true;

        while (continuePlaying) {
            playGame();

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if ("2".equals(choice)) {
                continuePlaying = false;
            }
            else if ("1".equals(choice)) {
                continuePlaying = true;
            }
            else throw new IllegalArgumentException("1 또는 2를 입력하세요");
        }
    }

    public static void playGame() {
        List<Integer> secretNumber = generateSecretNumber();
        int tries = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> guess = getGuessFromUser();

            List<Integer> feedback = checkGuess(secretNumber, guess);

            if (feedback.get(0) == 0 && feedback.get(1) == 0) {
                System.out.println("낫싱");
            } 

            else if (feedback.get(0) == 3) {
            	System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            
            else if (feedback.get(0) == 0){  //볼 뿐일 떄
                System.out.println(feedback.get(1) + "볼 ");
            }
            else if (feedback.get(1) == 0){  //스트라이크 뿐일 때
                System.out.println(feedback.get(0) + "스트라이크");
            }
            else {
                System.out.println(feedback.get(1) + "볼 " + feedback.get(0) + "스트라이크");
            }
        }
    }

    public static List<Integer> generateSecretNumber() {
        List<Integer> secret = new ArrayList<>();
        while (secret.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!secret.contains(randomNumber)) {
                secret.add(randomNumber);
            }
        }
        return secret;
    }

    public static List<Integer> getGuessFromUser() {
        System.out.print("3자리 숫자를 추측하세요: ");
        String input = Console.readLine();
        List<Integer> guess = new ArrayList<>();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
        for (int i = 0; i < 3; i++) {
            guess.add(Character.getNumericValue(input.charAt(i)));
        }
        return guess;
    }

    public static List<Integer> checkGuess(List<Integer> secret, List<Integer> guess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (secret.get(i).equals(guess.get(i))) {
                strikes++;
            } else if (secret.contains(guess.get(i))) {
                balls++;
            }
        }
        return List.of(strikes, balls);
    }
}
