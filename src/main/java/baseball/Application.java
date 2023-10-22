package baseball;

import static baseball.Constant.GAME_NUM_SIZE;
import static baseball.Constant.MAX_RANDOM_NUMBER;
import static baseball.Constant.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String flag;
        do {
            startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            flag = askReplayOrExit();
        } while (flag.equals("1"));  // 1을 입력하면 게임 새로 시작
    }

    private static void startGame() {
        List<String> computerNum = createComputerNumber();
        String result;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<String> playerNum = getPlayerInput();
            verifyPlayerNum(playerNum);
            result = matchPlayerNum(computerNum, playerNum);
            System.out.println(result);
        } while (!result.equals("3스트라이크"));
    }

    private static void verifyPlayerNum(List<String> playerNum) {
        isNonDigit(playerNum);
        isThreeDigitNumber(playerNum);
        hasRepeatedDigitNumber(playerNum);
    }

    private static List<String> createComputerNumber() {
        Set<String> computerNum = new HashSet<>();
        while (computerNum.size() < GAME_NUM_SIZE) {
            String randNum = String.valueOf(
                    Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
            computerNum.add(randNum);
        }

        return new ArrayList<>(computerNum);
    }

    private static List<String> getPlayerInput() {
        return Arrays.asList(
                Console.readLine()
                        .split(""));
    }


    // 사용자가 입력한 값이 숫자인지 확인한다.
    private static void isNonDigit(List<String> playerNum) {
        try {
            for (String pNum : playerNum) {
                Integer.parseInt(pNum);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 게임이 종료됩니다.");
        }
    }

    // 사용자가 입력한 값이 3자리 숫자인지 확인한다.
    private static void isThreeDigitNumber(List<String> playerNum) {
        if (playerNum.size() != 3) {
            throw new IllegalArgumentException("숫자가 3자리가 아닙니다. 게임이 종료됩니다.");
        }
    }

    // 사용자가 입력한 값에서 2개 이상 중복되는 숫자가 있는 경우
    private static void hasRepeatedDigitNumber(List<String> playerNum) {
        Set<String> digitNumSet = new HashSet<>();

        for (String pNum : playerNum) {
            if (digitNumSet.contains(pNum)) {
                throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다. 게임이 종료됩니다.");
            }
            digitNumSet.add(pNum);
        }
    }

    private static String matchPlayerNum(List<String> computerNum, List<String> playerNum) {
        long ballCount = IntStream.range(0, GAME_NUM_SIZE)
                .filter(i -> !computerNum.get(i).equals(playerNum.get(i))
                        && computerNum.contains(playerNum.get(i)))
                .count();

        long strikeCount = IntStream.range(0, GAME_NUM_SIZE)
                .filter(i -> computerNum.get(i).equals(playerNum.get(i)))
                .count();

        return getGameResult(ballCount, strikeCount);
    }

    private static String getGameResult(long ballCount, long strikeCount) {
        String result = "";

        if (ballCount > 0) {
            result += ballCount + "볼";
        }
        if (strikeCount > 0) {
            result += (result.isEmpty() ? "" : " ") + strikeCount + "스트라이크";
        }

        return result.isEmpty() ? "낫싱" : result;
    }


    private static String askReplayOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        isValidUserChoice(choice);

        return choice;
    }

    public static void isValidUserChoice(String choice) {
        // 1과 2가 아닌 다른 수를 입력할 경우
        if (!(choice.equals("1") || choice.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다. 게임이 종료됩니다.");
        }
    }
}