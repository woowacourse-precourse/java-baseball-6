package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    static final String BALL_MESSAGE = "볼";
    static final String STRIKE_MESSAGE = "스트라이크";
    static final String NOTHING_MESSAGE = "낫싱";
    static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String GET_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printStart();
        getUserNumbersList();
    }
    public static void printStart() {
        System.out.println(START_MESSAGE);
    }
    public static List<Integer> getStrikeBallCount(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int strikeCount = 0;
        int ballCount = 0;
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
        return Arrays.asList(strikeCount, ballCount);
    }
    public static List<Integer> getComputerNumbersList() {
        List<Integer> computerNumbersList = new ArrayList<>();
        while (computerNumbersList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
    public static void validateUserNumbersString(String userNumbers) {
        validateEmptyOrNullOfInputString(userNumbers);
        if (!userNumbers.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 1~9 사이 숫자로 이루어진 세자리 숫자가 아닙니다.");
        }
        Set<String> duplicationCheckSet = new HashSet<>();
        duplicationCheckSet.addAll(Arrays.asList(userNumbers.split("")));
        if (duplicationCheckSet.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 중복이 있습니다.");
        }
    }
    public static void validateEmptyOrNullOfInputString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 null이거나 비어있습니다.");
        }
    }
}
