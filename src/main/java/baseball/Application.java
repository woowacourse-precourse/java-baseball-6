package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 기능: 힌트가 3스트라이크면 게임 종료
    private static boolean isGameEnd(String hint) {
        if (hint.equals("3스트라이크")) {
            printGameEndMessage();
            return true;
        }
        return false;
    }

    // 기능: 힌트 얻기
    private static String getHint(List<Integer> computerBalls, List<Integer> playerBalls) {
        if (isNothing(computerBalls, playerBalls)) {
            return "낫싱";
        }
        int strikeCount = getStrikeCount(computerBalls, playerBalls);
        int ballCount = getBallCount(computerBalls, playerBalls);
        return getResult(ballCount, strikeCount);
    }

    private static String getResult(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();
        if (ballCount > 0) {
            result.append(String.format("%d볼 ", ballCount));
        }
        if (strikeCount > 0) {
            result.append(String.format("%d스트라이크", strikeCount));
        }
        return result.toString().trim();
    }

    // 기능: 같은 수가 전혀 없으면 낫싱
    private static boolean isNothing(List<Integer> computerBalls, List<Integer> playerBalls) {
        return computerBalls.stream()
                .noneMatch(playerBalls::contains);
    }

    // 기능: 같은 수가 같은 자리에 있는 스트라이크의 개수 세기
    private static int getStrikeCount(List<Integer> computerBalls, List<Integer> playerBalls) {
        int strikeCount = 0;
        for (int ballPosition = 0; ballPosition < computerBalls.size(); ballPosition++) {
            int playerBall = playerBalls.get(ballPosition);
            int computerBall = computerBalls.get(ballPosition);
            if (computerBalls.contains(playerBall) && playerBall == computerBall) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // 기능: 같은 수가 다른 자리에 있는 볼의 개수 세기
    private static int getBallCount(List<Integer> computerBalls, List<Integer> playerBalls) {
        int ballCount = 0;
        for (int ballPosition = 0; ballPosition < computerBalls.size(); ballPosition++) {
            int playerBall = playerBalls.get(ballPosition);
            int computerBall = computerBalls.get(ballPosition);
            if (computerBalls.contains(playerBall) && playerBall != computerBall) {
                ballCount++;
            }
        }
        return ballCount;
    }

    // 기능: 게임 종료 후, 게임 재시작 여부
    private static boolean isNoMoreGame() {
        printRestartGameMessage();
        String restartCommand = Console.readLine();
        validateRestartCommandInput(restartCommand);
        if (restartCommand.equals("2")) {
            return true;
        }
        return false;
    }

    // 기능: 사용자의 공을 입력 받고 생성한다
    private static List<Integer> createPlayerBalls() {
        String number = Console.readLine();
        validatePlayerBallInput(number);
        return number
                .chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    // 기능: 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    private static List<Integer> createComputerBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return computerBalls;
    }

    // 기능: 게임 재시작 입력 검증
    private static void validateRestartCommandInput(String restartCommand) {
        validateLength(restartCommand, 1);
        validateNumeric(restartCommand);
        validateOneOrTwo(restartCommand);
    }

    // 기능: 1 또는 2만 입력해야 한다
    private static void validateOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
    }

    // 기능: 사용자 공 입력 검증
    private static void validatePlayerBallInput(String number) {
        validateLength(number, 3);
        validateNumeric(number);
        validateUnique(number);
    }

    // 기능: 서로 다른 숫자로만 입력해야 한다
    private static void validateUnique(String input) {
        Set<Character> uniqueNums = new HashSet<>();
        for (int numberIdx = 0; numberIdx < input.length(); numberIdx++) {
            uniqueNums.add(input.charAt(numberIdx));
        }
        if (uniqueNums.size() != 3) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
        }
    }

    // 기능: 숫자만 입력해야 한다
    private static void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    // 기능: length 자릿수로 입력해야 한다
    private static void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(length + " 자릿수로 입력해야 합니다.");
        }
    }

    private static void printInitialGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void printHint(String hint) {
        System.out.println(hint);
    }

    private static void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
