package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int DIGIT_COUNT = 3;
    private static final String RESTART_OPTION = "1";
    private static final String EXIT_OPTION = "2";


    public static void main(String[] args) {
        runGame();
    }


    // 게임 실행
    private static void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            playGame();

            String reGame = askForReGame();

            if (!reGame.equals(RESTART_OPTION)) {
                System.out.println("게임 종료");
                break;
            }
        }
    }


    // 게임 진행
    private static void playGame() {
        List<Integer> computer = createRandomNumbers();

        while (true) {
            String userInput = getUserInput();
            List<Integer> userNumbers = convertInputToNumberList(userInput);
            int[] result = calculateResult(computer, userNumbers);
            printResult(result);

            if (result[1] == DIGIT_COUNT) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
                return;
            }
        }
    }

    // 재시작 여부 입력
    private static String askForReGame() {
        System.out.print("게임을 새로 시작하려면 " + RESTART_OPTION + ", 종료하려면 " + EXIT_OPTION + "를 입력하세요: ");
        String reGame = Console.readLine();

        if (reGame.equals(RESTART_OPTION) || reGame.equals(EXIT_OPTION)) {
            return reGame;
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. " + RESTART_OPTION + " 또는 " + EXIT_OPTION + "를 입력하세요.");
        }
    }


    // 무작위 숫자 리스트를 반환
    private static List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new ArrayList<>(computer);
    }

    // 사용자 숫자 입력
    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 사용자 입력을 숫자 리스트로 변환
    private static List<Integer> convertInputToNumberList(String input) {
        validateInputLength(input);
        validateInputIsNumeric(input);
        validateUniqueDigits(input);

        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    // 사용자 입력의 길이가 3인지 검증
    private static void validateInputLength(String input) {
        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }
    }

    // 사용자 입력이 숫자로만 이루어져 있는지 검증
    private static void validateInputIsNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
    }

    // 사용자 입력의 각 숫자가 서로 다른지 검증
    private static void validateUniqueDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();

        for (char digitChar : input.toCharArray()) {
            if (uniqueDigits.contains(digitChar)) {
                throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해야 합니다.");
            }
            uniqueDigits.add(digitChar);
        }
    }

    // 볼과 스트라이크를 계산
    private static int[] calculateResult(List<Integer> computer, List<Integer> userInput) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int computerDigit = computer.get(i);
            int userDigit = userInput.get(i);

            if (computerDigit == userDigit) {
                strike++;
            } else if (computer.contains(userDigit)) {
                ball++;
            }
        }

        return new int[]{ball, strike};
    }

    // 결과 출력
    private static void printResult(int[] result) {
        int ball = result[0];
        int strike = result[1];

        if (ball > 0 || strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }


}
