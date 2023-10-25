package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public static int getUserInput() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public static void main(String[] args) {
        int minRange = 100;
        int maxRange = 999;

        int randomNum = generateRandomNumber(minRange, maxRange);
        System.out.println("랜덤한 세 자릿수: " + randomNum);

        int userInput = getUserInput();
        System.out.println("사용자 입력: " + userInput);
    }
}