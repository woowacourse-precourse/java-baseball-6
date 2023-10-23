package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;
    private static final String GAME_RESTART = "1";
    private static final String GAME_QUIT = "2";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;
        while (continueGame) {
            continueGame = startNewRound();
        }
    }

    /* 새로운 게임 반복 */
    private static boolean startNewRound() {
        List<Integer> computerNumbers = generateRandomNumbers();

        boolean correctAnswer = false;

        while (!correctAnswer) {
            List<Integer> playerNumbers = getPlayerInput();
            correctAnswer = checkIfPlayerWins(computerNumbers, playerNumbers);

            if (!correctAnswer) {
                continue;
            }
            
            return askContinue();
        }
        return true;
    }

    /* 플레이어 입력 받기 */
    private static List<Integer> getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();

        validateInput(inputNumbers);

        return convertInputToNumbers(inputNumbers);
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

    /* 맞췄는지 체크 */
    private static boolean checkIfPlayerWins(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = getStrikeCount(computerNumbers, playerNumbers);
        if (strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        int ballCount = getBallCount(computerNumbers, playerNumbers);

        printCount(ballCount, strikeCount);

        return false;
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

        char[] chars = inputNumbers.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            // 숫자인지 확인
            if (!Character.isDigit(currentChar)) {
                throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
            }

            //각 숫자가 서로 다른지 확인
            for (int j = i + 1; j < chars.length; j++) {
                if (currentChar == chars[j]) {
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
            if (computerNumbers.contains(playerNumbers.get(i)) && !computerNumbers.get(i)
                    .equals(playerNumbers.get(i))) {
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
            String instruction = String.format(
                    "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
                    GAME_RESTART,
                    GAME_QUIT
            );
            System.out.println(instruction);
            String inputNumber = Console.readLine();

            switch (inputNumber) {
                case GAME_RESTART:
                    return true;
                case GAME_QUIT:
                    return false;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    break;
            }
        }
    }
}