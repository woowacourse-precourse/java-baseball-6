package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        final int INPUT_LIMIT = 3;

        // User Input process
        boolean isQuit = false;
        while (!isQuit) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // Computer Randomized Number Generate
            List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            System.out.println(computerNumbers);

            System.out.print("숫자를 입력해주세요 : ");

            // TODO: Input Validation
            String line = Console.readLine();
            if (line.length() != INPUT_LIMIT) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
            char[] charArray = line.toCharArray();
            line = null;
            for (char c : charArray) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException("숫자만 입력해주세요.");
                }
                if (c < '1' || '9' < c) {
                    throw new IllegalArgumentException("숫자의 범위는 0~9로 입력해주세요.");
                }
            }
            int ball = 0, strike = 0;
            for (int index = 0; index < INPUT_LIMIT; index++) {
                int num = Character.getNumericValue(charArray[index]);
                if (computerNumbers.get(index) == num) {
                    strike++;
                } else if (computerNumbers.contains(num)) {
                    ball++;
                }
            }

            // Output Process
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            // isCorrect
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String retryInput = Console.readLine();
                if (retryInput == null || retryInput.length() != 1) {
                    throw new IllegalArgumentException("잘못된 입력값을 입력하셨습니다.");
                } else if (retryInput.equals("2")) {
                    isQuit = true;
                } else if (retryInput.equals("1")) {
                    System.out.println(computerNumbers);
                }

            }
        }
    }
}