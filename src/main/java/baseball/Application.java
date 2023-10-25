package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumbers = makeRandomNumber();
        while (true) {
            List<Integer> userNumbers = getUserNumber();
            int result = getResultGame(randomNumbers, userNumbers);

            if (result == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                boolean reStart = reStartGame();
                if (reStart) {
                    randomNumbers = makeRandomNumber();
                    continue;
                }
                break;
            }
        }

    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            numbers.add(number);
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private static int getResultGame(List<Integer> randomNumbers, List<Integer> userNumbers) {
        int ballCount = 0;
        int strikeCount = 0;
        String resultMessage = "";

        for (int i = 0; i < 3; i++) {
            int ballNumber = randomNumbers.get(i);

            if (userNumbers.contains(ballNumber) && ballNumber != userNumbers.get(i)) {
                ballCount++;
            }
        }

        for (int i = 0; i < 3; i++) {
            int strikeNumber = randomNumbers.get(i);

            if (strikeNumber == userNumbers.get(i)) {
                strikeCount++;
            }
        }
        if (ballCount != 0) {
            resultMessage += ballCount + "볼";
            if (strikeCount != 0) {
                resultMessage = ballCount + "볼 ";
            }
        }
        if (strikeCount != 0) {
            resultMessage += strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount == 0) {
            resultMessage += "낫싱";
        }
        System.out.println(resultMessage);
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return strikeCount;
    }

    private static boolean reStartGame() {
        String input = Console.readLine();
        int reStartNumber = Integer.parseInt(input);

        if (reStartNumber == 1) {
            return true;
        }
        return false;
    }
}