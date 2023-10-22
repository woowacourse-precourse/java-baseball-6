package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;
        while (continueGame) {
            List<Integer> computerNumbers = generateRandomNumbers();
            continueGame = playGame(computerNumbers);
            if (continueGame) {
                continueGame = askContinue();
            }
        }
    }
    /* 랜덤 컴퓨터 숫자 생성 */
    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /* 게임 시작 */
    private static boolean playGame(List<Integer> computerNumbers) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumbers = Console.readLine();

            try {
                validateInput(inputNumbers);
                List<Integer> playerNumbers = convertInputToNumbers(inputNumbers);

                int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
                if (strikeCount == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    return true;
                }

                int ballCount = getBallCount(computerNumbers, playerNumbers);

                printCount(ballCount, strikeCount);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    /* 입력 숫자 검증*/
    private static void validateInput(String inputNumbers) {
        // 0을 포함하는지 확인
        if (inputNumbers.contains("0")) {
            throw new IllegalArgumentException("입력에서 '0'은 허용되지 않습니다.");
        }
        // 3자리 확인
        if (inputNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        }
        // 숫자인지 확인
        for (char ch : inputNumbers.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
            }
        }
        //각 숫자가 서로 다른지 확인
        for (int i = 0; i < inputNumbers.length(); i++) {
            char currentChar = inputNumbers.charAt(i);
            for (int j = i + 1; j < inputNumbers.length(); j++) {
                if (currentChar == inputNumbers.charAt(j)) {
                    throw new IllegalArgumentException("같은 숫자가 중복으로 입력되었습니다.");
                }
            }
        }
    }

    /* 입력받은 숫자(string) => List<Integer> */
    private static List<Integer> convertInputToNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : inputNumbers.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
    /* 스트라이크 갯수 세기*/
    private static int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
    /* 볼 갯수 세기*/
    private static int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.contains(playerNumbers.get(i)) && !computerNumbers.get(i).equals(playerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    /*스트라이크 볼 카운트 출력*/
    private static void printCount(int ballCount, int strikeCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private static boolean askContinue() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputNumber = Console.readLine();

            switch (inputNumber) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    break;
            }
        }
    }
}