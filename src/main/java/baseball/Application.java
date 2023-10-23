package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameStatus = 1;
        while (gameStatus == 1) {
            List<Integer> computerNumbers = chooseRandomNumbers();

            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.print("숫자를 입력해주세요 : ");
                int userNumbers = getUserNumbers();
                isCorrect = checkNumbers(computerNumbers, userNumbers);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameStatus = getRestart();
        }
    }

    private static List<Integer> chooseRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    private static int getUserNumbers() {
        String userString = Console.readLine();
        int userNumbers;

        try {
            userNumbers = Integer.parseInt(userString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (userString.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        if (userString.charAt(0) == userString.charAt(1)
                || userString.charAt(1) == userString.charAt(2)
                || userString.charAt(0) == userString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }

        return userNumbers;
    }

    private static boolean checkNumbers(List<Integer> computerNumbers, int userNumbers) {
        String answer = "";
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int compareNumber = userNumbers / (int) Math.pow(10, 2 - i);
            userNumbers %= (int) Math.pow(10, 2 - i);
            if (!computerNumbers.contains(compareNumber)) {
                continue;
            }
            if (computerNumbers.indexOf(compareNumber) == i) {
                strikes += 1;
            } else {
                balls += 1;
            }
        }

        if (balls == 0 && strikes == 0) {
            answer += "낫싱";
        }
        if (balls > 0) {
            answer += (balls + "볼 ");
        }
        if (strikes > 0) {
            answer += (strikes + "스트라이크");
        }

        System.out.println(answer);

        if (strikes == 3) {
            return true;
        }
        return false;
    }

    private static int getRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userString = Console.readLine();

        if (!(userString.equals("1") || userString.equals("2"))) {
            throw new IllegalArgumentException("1, 2 중 하나를 입력해주세요.");
        }

        return Integer.parseInt(userString);
    }
}
