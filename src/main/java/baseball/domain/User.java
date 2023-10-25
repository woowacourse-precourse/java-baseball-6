package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {

    public static ArrayList<Integer> inputUserGuess(int NUMBER_LENGTH) {
        // 1부터 9까지 서로 다른 세 자리의 수 입력받기 (사용자)
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();

        // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
        ArrayList<Integer> userNumArray = generateUserNumArray(userNum, NUMBER_LENGTH);

        return userNumArray;
    }

    public static ArrayList<Integer> generateUserNumArray(String userNum, int NUMBER_LENGTH) {
        ArrayList<Integer> userNumArray = new ArrayList<>();

        for (char c : userNum.toCharArray()) {
            int digit = Character.getNumericValue(c);
            addUniqueDigit(digit, userNumArray);
        }

        validateInputLength(userNumArray, NUMBER_LENGTH);

        return userNumArray;
    }

    private static void addUniqueDigit(int digit, ArrayList<Integer> userNumArray) {
        if (userNumArray.contains(digit)) {
            throw new IllegalArgumentException();
        }
        userNumArray.add(digit);
    }

    private static void validateInputLength(ArrayList<Integer> userNumArray, int NUMBER_LENGTH) {
        if (userNumArray.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
