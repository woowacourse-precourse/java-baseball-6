package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static final int NUM_OF_DIGITS = 3;
    static boolean GAME = true;

    public static void main(String[] args) {
        List<Integer> computerNumber = createRandomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (GAME){
            int[] userNumber = new int[NUM_OF_DIGITS];
            getUserInput(userNumber);
            String ballStrikeCheck = checkNumber(userNumber, computerNumber);
            System.out.println(ballStrikeCheck);
            if (!GAME)
                break;
        }
    }

    /**
     * 컴퓨터가 랜덤한 3 자리 정수를 생성하는 함수
     *
     * @return ArrayList[3]
     */
    public static List<Integer> createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자가 입력한 숫자를 3 자리로 나눠 배열에 저장하는 함수
     *
     * @param userNumberDigits
     */
    private static void getUserInput(int[] userNumberDigits) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        Integer userNumber = null;
        try {
            String userNumberString = scanner.next();
            userNumber = Integer.parseInt(userNumberString);
            if (userNumberString.length() != NUM_OF_DIGITS)
                throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for (int i = NUM_OF_DIGITS - 1; i >= 0; i--) {
            int filteredNum = (int) (userNumber % Math.pow(10, i + 1));
            int digit = filteredNum / (int) Math.pow(10, i);
            int index = NUM_OF_DIGITS - 1 - i;
            userNumberDigits[index] = digit;
        }
    }

    public static String checkNumber(int[] userNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < NUM_OF_DIGITS; i++) {
            for (int j = 0; j < NUM_OF_DIGITS; j++) {
                if (userNumbers[i] == computerNumbers.get(j) && i != j)
                    ballCount++;
                if (userNumbers[i] == computerNumbers.get(j) && i == j)
                    strikeCount++;
            }
        }
        String result = "아웃";
        if (ballCount != 0 && strikeCount == 0) result = String.format("%d볼", ballCount);
        if (ballCount == 0 && strikeCount != 0) result = String.format("%d스트라이크", strikeCount);
        if (ballCount != 0 && strikeCount != 0) result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        if (strikeCount == NUM_OF_DIGITS) {
            result = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", NUM_OF_DIGITS);
            GAME = false;
        }
        return result;
    }
}
