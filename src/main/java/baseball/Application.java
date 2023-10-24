package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = makeNumbers();

        while (true) {
            // 숫자 입력
            System.out.println("숫자를 입력해주세요: ");
            String playerInput = Console.readLine();

            // 길이 검증
            validateLength(playerInput);

            // 숫자 검증
            int playerNumber = validateNumber(playerInput);

            List<Integer> playerNumbers = new ArrayList<>();
            while (playerNumber > 0) {
                int number = playerNumber % 10;

                validateRange(number);

                validateDuplication(playerNumbers, number);

                playerNumbers.add(number);
                playerNumber = playerNumber / 10;
            }

            playerNumbers = reverse(playerNumbers);

            Result result = calculate(computer, playerNumbers);
        }
    }

    static List<Integer> makeNumbers () {
        // 임의의 수 3개를 만든다.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void validateLength (String playerInput){
        // 길이 검증
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    static int validateNumber (String playerInput){
        int playerNumber;
        // 숫자 검증
        try {
            playerNumber = Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return playerNumber;
    }

    private static void validateRange(int number) {
        // 1에서 9까지의 수인지 검증
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(List<Integer> playerNumbers, int number) {
        // 서로 다른지 검증
        if (playerNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    static public List<Integer> reverse (List < Integer > playerNumbers) {
        List<Integer> reverse = new ArrayList<>();
        for (int i = playerNumbers.size() - 1; i >= 0; i--) {
            reverse.add(playerNumbers.get(i));
        }
        return reverse;
    }

    static Result calculate (List <Integer> computer, List <Integer> playerNumbers){
        Result result = new Result();
        for (int i = 0; i < 3; i++) {
            Integer playerBall = playerNumbers.get(i);

            if (!computer.contains(playerBall))
                result.increaseNothing();
            else if (playerBall != computer.get(i))
                result.increaseBall();
            else
                result.increaseStrike();
        }

        return result;
    }
}
