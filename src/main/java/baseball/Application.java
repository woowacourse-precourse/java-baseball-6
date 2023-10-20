package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int NUMBERS_LENGTH = 3;
    static final String MORE_GAME = "1";
    static final String QUIT_GAME = "2";
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    static final String BALL_MESSAGE = "볼";
    static final String STRIKE_MESSAGE = "스트라이크";
    static final String NOTHING_MESSAGE = "낫싱";
    static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String GET_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGames();
    }
    public static void playGames() {
        printStart();
        while(true){
            playGameOnce();
            if (getMoreGame().equals(QUIT_GAME)){
                break;
            }
        }
    }
    public static void playGameOnce() {
        List<Integer> computerNumbersList = getComputerNumbersList();
        while(true) {
            List<Integer> userNumbersList = getUserNumbersList();
            List<Integer> ballStrikeCount = getBallStrikeCount(computerNumbersList, userNumbersList);
            printBallStrike(ballStrikeCount.get(0), ballStrikeCount.get(1));
            if (isAnswer(ballStrikeCount.get(1))) {
                printAnswer();
                printGetRestart();
                break;
            }
        }
    }
    public static void printGetRestart() {
        System.out.println(GET_RESTART_MESSAGE);
    }
    public static void printStart() {
        System.out.println(START_MESSAGE);
    }
    public static void printAnswer() {
        System.out.println(ANSWER_MESSAGE);
    }
    public static void printBallStrike(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (ballCount != 0) {
            System.out.print(ballCount+BALL_MESSAGE);
            if (strikeCount != 0) {
                System.out.print(" "+strikeCount+STRIKE_MESSAGE);
            }
            System.out.println();
            return;
        }
        System.out.println(strikeCount+STRIKE_MESSAGE);
    }
    public static boolean isAnswer(int strikeCount) {
        if (strikeCount == NUMBERS_LENGTH)
            return true;
        return false;
    }
    public static List<Integer> getBallStrikeCount(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < computerNumbersList.size(); i++) {
            int computerNumber = computerNumbersList.get(i);
            int userNumber = userNumbersList.get(i);
            if (computerNumber == userNumber) {
                strikeCount++;
                continue;
            }
            if (computerNumbersList.contains(userNumber)){
                ballCount++;
            }
        }
        return Arrays.asList(ballCount, strikeCount);
    }
    public static int getBallCount(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int ballCount = 0;
        for (int i = 0; i < userNumbersList.size(); i++) {
            int userNumber = userNumbersList.get(i);
            if (userNumber != computerNumbersList.get(i) && computerNumbersList.contains(userNumber))
                ballCount++;
        }
        return ballCount;
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
        System.out.print(GET_NUMBER_MESSAGE);
        String userNumbersString = Console.readLine();
        validateUserNumbersString(userNumbersString);
        for(String userNumberString : userNumbersString.split("")) {
            userNumbersList.add(Integer.parseInt(userNumberString));
        }
        return userNumbersList;
    }
    public static String getMoreGame() {
        String moreGame = Console.readLine();
        validateMoreGameString(moreGame);
        return moreGame;
    }
    public static void validateUserNumbersString(String userNumbers) {
        validateEmptyOrNullOfInputString(userNumbers);
        validateStringLength(userNumbers, NUMBERS_LENGTH);
        validateStringDistinct(userNumbers);
        validateStringDigit(userNumbers);
    }
    public static void validateMoreGameString(String moreGame) {
        validateEmptyOrNullOfInputString(moreGame);
        if (!moreGame.equals(MORE_GAME) && !moreGame.equals(QUIT_GAME))
            throw new IllegalArgumentException("[ERROR] 입력 값이 "+MORE_GAME+" 또는 "+QUIT_GAME+" 가 아닙니다.");
    }
    public static void validateEmptyOrNullOfInputString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }
    public static void validateStringLength(String str, int length) {
        if (str.length() != length)
            throw new IllegalArgumentException("[ERROR] 입력 값의 길이가 "+length+"(이)가 아닙니다.");
    }
    public static void validateStringDistinct(String str) {
        Set<String> inputSet = new HashSet<>(Arrays.asList(str.split("")));
        if (str.length() != inputSet.size())
            throw new IllegalArgumentException("[ERROR] 입력 값에 중복이 있습니다.");
    }
    public static void validateStringDigit(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException("[ERROR] 입력 값이 숫자로만 이루어져 있지 않습니다.");
        }
    }
}
