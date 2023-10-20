package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int NUMBERS_LENGTH = 3;
    static final String GAME_RESTART = "1";
    static final String GAME_OVER = "2";
    static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final String NOTHING = "낫싱";
    static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGames();
    }

    public static void playGames() {
        printGameStart();
        do {
            playGameOnce();
            printAnswer();
        } while (getGameRestart().equals(GAME_RESTART));
    }

    public static void playGameOnce() {
        List<Integer> computerNumbersList = getComputerNumbersList();
        int ballCount;
        int strikeCount;
        do {
            List<Integer> userNumbersList = getUserNumbersList();
            ballCount = getBallCount(computerNumbersList, userNumbersList);
            strikeCount = getStrikeCount(computerNumbersList, userNumbersList);
            printBallStrikeCount(ballCount, strikeCount);
        } while (!isAnswer(strikeCount));
    }

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printAnswer() {
        System.out.println(ANSWER_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
    }

    public static void printBallStrikeCount(int ballCount, int strikeCount) {
        printBallCount(ballCount);
        printStrikeCount(strikeCount);
        printNothing(ballCount, strikeCount);
        System.out.println();
    }

    public static void printBallCount(int ballCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + BALL + " ");
        }
    }

    public static void printStrikeCount(int strikeCount) {
        if (strikeCount != 0) {
            System.out.print(strikeCount + STRIKE);
        }
    }

    public static void printNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING);
        }
    }

    public static boolean isAnswer(int strikeCount) {
        return strikeCount == NUMBERS_LENGTH;
    }

    public static int getBallCount(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int ballCount = 0;
        for (int i = 0; i < userNumbersList.size(); i++) {
            int userNumber = userNumbersList.get(i);
            int computerNumber = computerNumbersList.get(i);
            if (userNumber != computerNumber && computerNumbersList.contains(userNumber)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static int getStrikeCount(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int strikeCount = 0;
        for (int i = 0; i < userNumbersList.size(); i++) {
            int userNumber = userNumbersList.get(i);
            int computerNumber = computerNumbersList.get(i);
            if (userNumber == computerNumber) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static List<Integer> getComputerNumbersList() {
        List<Integer> computerNumbersList = new ArrayList<>();
        while (computerNumbersList.size() < NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerNumbersList.contains(randomNumber)) {
                computerNumbersList.add(randomNumber);
            }
        }
        return computerNumbersList;
    }

    public static List<Integer> getUserNumbersList() {
        List<Integer> userNumbersList = new ArrayList<>();
        System.out.print(ENTER_NUMBER_MESSAGE);
        String userNumbersString = Console.readLine();
        validateUserNumbersString(userNumbersString);
        for (String userNumberString : userNumbersString.split("")) {
            userNumbersList.add(Integer.parseInt(userNumberString));
        }
        return userNumbersList;
    }

    public static String getGameRestart() {
        String moreGame = Console.readLine();
        validateGameRestartString(moreGame);
        return moreGame;
    }

    public static void validateUserNumbersString(String userNumbers) {
        validateEmptyOrNullOfInputString(userNumbers);
        validateInputStringLength(userNumbers, NUMBERS_LENGTH);
        validateInputStringDistinct(userNumbers);
        validateInputStringDigit(userNumbers);
    }

    public static void validateGameRestartString(String gameRestart) {
        validateEmptyOrNullOfInputString(gameRestart);
        if (!gameRestart.equals(GAME_RESTART) && !gameRestart.equals(GAME_OVER)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 " + GAME_RESTART + " 또는 " + GAME_OVER + " 가 아닙니다.");
        }
    }

    public static void validateEmptyOrNullOfInputString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }

    public static void validateInputStringLength(String inputString, int length) {
        if (inputString.length() != length) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 길이가 " + length + "(이)가 아닙니다.");
        }
    }

    public static void validateInputStringDistinct(String inputString) {
        Set<String> inputStringSet = new HashSet<>(Arrays.asList(inputString.split("")));
        if (inputString.length() != inputStringSet.size()) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 중복이 있습니다.");
        }
    }

    public static void validateInputStringDigit(String inputString) {
        for (char ch : inputString.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자로만 이루어져 있지 않습니다.");
            }
        }
    }
}
