package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    final static int LENGTH_OF_CORRECTION_ANSWER = 3;
    final static int RANGE_START = 0;
    final static int RANGE_END = 9;
    final static char ZERO_CHARACTER = '0';

    enum BallType {
        STRIKE(0), BALL(1), NONE(2);

        BallType(int i) {
            this.value = i;
        }

        final int value;
    }

    static List<Integer> randomNumberList;
    static List<Integer> userNumberList;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        runGameRepeatedly();

        System.out.println("게임이 종료되었습니다.");
    }

    /**
     * 반복성 게임 실행
     */
    public static void runGameRepeatedly() {
        do {
            runGameOnce();
        } while (isGameRetry());
    }

    /**
     * 게임 재시작 여부 받기
     *
     * @return 재시작 여부
     */
    public static boolean isGameRetry() {
        final int INDEX_YES = 0;
        List<String> allowedAnswers = Arrays.asList("1", "2");
        String userInput;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        userInput = Console.readLine();
        if (!allowedAnswers.contains(userInput)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }

        return allowedAnswers.get(INDEX_YES).equals(userInput);
    }

    /**
     * 일회성 게임 실행
     */
    public static void runGameOnce() {
        String userInput;
        List<Integer> testResult;

        randomNumberList = getNewRandomNumberList();
        do {
            userInput = getInputOnGame();
            inputValidationCheck(userInput);
            userNumberList = numericString2List(userInput);
            testResult = userAnswerTesting();
            printTestResult(testResult);

        } while (!isUserAnswerCorrect(testResult));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 정답을 모두 맞추었는지 확인
     *
     * @return 사용자 입력이 정답인 경우 true
     */
    public static boolean isUserAnswerCorrect(List<Integer> testResult) {
        int count;
        count = testResult.get(BallType.STRIKE.value);
        return count == LENGTH_OF_CORRECTION_ANSWER;
    }

    /**
     * 입력 및 결괏값 비교 출력
     *
     * @param result 포매팅 된 입력값
     */
    public static void printTestResult(List<Integer> result) {
        int none;
        int ball;
        int strike;

        none = result.get(BallType.NONE.value);
        if (none == LENGTH_OF_CORRECTION_ANSWER) {
            System.out.println("낫싱");
            return;
        }

        ball = result.get(BallType.BALL.value);
        strike = result.get(BallType.STRIKE.value);

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();
    }

    /**
     * 숫자 야구의 전체 검사 요소
     *
     * @return 검사 결과
     */
    public static List<Integer> userAnswerTesting() {
        final Integer[] answerList = {0, 0, 0};
        int answer;
        for (int i = 0; i < userNumberList.size(); ++i) {
            answer = answerElementTesting(i, userNumberList.get(i)).value;
            answerList[answer]++;
        }
        return Arrays.asList(answerList);
    }

    /**
     * 숫자 야구의 단일 요소 검사
     *
     * @param index 검사할 인덱스
     * @param value 검사할 값
     * @return 인덱스와 값이 일치할경우 Strike, 값만 일치하는 경우 Ball 그렇지 않은 경우 None
     */
    public static BallType answerElementTesting(int index, int value) {
        if (randomNumberList.get(index) == value) {
            return BallType.STRIKE;
        }
        if (randomNumberList.contains(value)) {
            return BallType.BALL;
        }

        return BallType.NONE;
    }

    /**
     * 게임을 위한 새로운 숫자 리스트 생성
     *
     * @return 길이 3의 Integer 리스트
     */
    public static List<Integer> getNewRandomNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < LENGTH_OF_CORRECTION_ANSWER) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            uniqueAdd(numberList, randomNumber);
        }
        return numberList;
    }

    /**
     * 리스트 내에 존재하지 않는 값인 경우 리스트에 추가
     *
     * @param list   값을 추가할 리스트
     * @param number 리스트에 추가할 값
     */
    public static void uniqueAdd(List<Integer> list, Integer number) {
        if (!list.contains(number)) {
            list.add(number);
        }
    }

    /**
     * 게임 중 사용자 입력 받기
     *
     * @return 사용자가 입력한 문자열 데이터
     */
    public static String getInputOnGame() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    /**
     * 문자열의 유효성 검사
     *
     * @param input 유효성 확인할 문자열
     */
    public static void inputValidationCheck(String input) {
        lengthValidationCheck(input);

        // 문자 내 숫자 검사
        char c;
        for (int i = 0; i < input.length(); ++i) {
            c = input.charAt(i);
            numberCharacterValidationCheck(c);
        }

    }

    /**
     * 아라비아 숫자(0-9)인 문자 유효성 검사
     *
     * @param character 아라비아 숫자 문자인지 확인할 문자
     * @throws IllegalArgumentException - '0' - '9'가 아닌 문자
     */
    public static void numberCharacterValidationCheck(char character) {
        int cNumber = Character.getNumericValue(character);
        cNumber -= Character.getNumericValue(ZERO_CHARACTER);
        if (!(RANGE_START <= cNumber && cNumber <= RANGE_END)) {
            throw new IllegalArgumentException("아라비아 숫자(0-9)가 아닌 문자입니다.");
        }
    }

    /**
     * 길이 유효성 검사
     *
     * @param input 길이 유효성을 확인할 문자열
     * @throws IllegalArgumentException - 길이가 3이 아님
     */
    public static void lengthValidationCheck(String input) {
        if (input.length() != LENGTH_OF_CORRECTION_ANSWER) {
            throw new IllegalArgumentException("문자열의 길이가 3이 아닙니다.");
        }
    }

    /**
     * 숫자 문자열을 한 글자씩 잘라 Integer 리스트 생성
     *
     * @param userInput 문자 0-9로 구성된 문자열
     * @return 문자열로 생성된 Integer 리스트
     */
    public static List<Integer> numericString2List(String userInput) {
        List<Integer> numberList = new ArrayList<>();
        char character;
        int number;

        for (int i = 0; i < userInput.length(); ++i) {
            character = userInput.charAt(i);
            number = Character.getNumericValue(character);
            number -= Character.getNumericValue(ZERO_CHARACTER);
            numberList.add(number);
        }

        return numberList;
    }
}
