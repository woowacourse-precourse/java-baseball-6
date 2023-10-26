package baseball;

// BaseballGameService.java (Service 클래스)

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameService {

    public void playGame() {
        String computerNumber = String.valueOf(generateRandomNumber());
        System.out.println("3자리 서로 다른 숫자를 입력하세요.");

        while (true) {
            String userGuess = Console.readLine();
            if (!isValidInput(userGuess)) {
                System.out.println("올바른 입력이 아닙니다. 3자리 서로 다른 숫자를 다시 입력하세요.");
                continue;
            }

            String result = calculateResult(userGuess, computerNumber);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private int generateRandomNumber() {
        return  Randoms.pickNumberInRange(100, 999);
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!input.matches("[0-9]+")) {
            return false;
        }
        return input.chars().distinct().count() == 3;
    }

    private String calculateResult(String guess, String answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            char guessedDigit = guess.charAt(i);
            char answerDigit = answer.charAt(i);
            if (guessedDigit == answerDigit) {
                strike++;
            } else if (answer.contains(String.valueOf(guessedDigit))) {
                ball++;
            }
        }
        if (strike > 0 && ball > 0) {
            return strike + "스트라이크 " + ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }
}
