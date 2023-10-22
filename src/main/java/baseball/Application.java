package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    final static int LENGTH_OF_CORRECTION_ANSWER = 3;
    final static int RANGE_START = 0;
    final static int RANGE_END = 9;

    public static void main(String[] args) {
        List<Integer> randomNumberList;
        String userInput;

        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumberList = getNewRandomNumberList();
        userInput = getInputOnGame();
        inputValidationCheck(userInput);

        System.out.println("게임이 종료되었습니다.");
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
        System.out.println("숫자를 입력해주세요: ");
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
        final char ZERO_CHARACTER = '0';
        Integer cNumber = Character.getNumericValue(character);
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
}
