package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int TARGET_LENGTH = 3;

    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = generateRandomNumbers();

            while (playGame(computer)) {
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String newGame = Console.readLine();
            if ("2".equals(newGame)) {
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < TARGET_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static boolean playGame(List<Integer> computer) {
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> player = getPlayerInput();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < TARGET_LENGTH; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }

        printResult(strike, ball);

        if (strike == TARGET_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    private static List<Integer> getPlayerInput() {
        List<Integer> player = new ArrayList<>();
        String playerInput = Console.readLine();

        if (playerInput.length() != TARGET_LENGTH) {
            throw new IllegalArgumentException("입력값은 3자리의 정수여야 합니다.");
        }

        for (char c : playerInput.toCharArray()) {
            int number = validateAndGetNumber(c);
            player.add(number);
        }
        return player;
    }

    private static int validateAndGetNumber(char c) {
        int number;
        try {
            number = Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }

        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("입력값은 1부터 9까지 중 하나의 정수여야 합니다.");
        }
        return number;
    }

    private static void printResult(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        String result = "";
        if (ball > 0) {
            result = ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        System.out.println(result.trim());
    }
}
