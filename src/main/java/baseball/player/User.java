package baseball.player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public int[] inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        char[] arr = readLine().toCharArray();
        return charToInt(arr);
    }

    private int[] charToInt(char[] arr) {
        if (arr.length >= 3) {
            throw new IllegalArgumentException("입력이 너무 깁니다. 3자리 숫자를 입력해 주세요.");
        }
        int[] userInput = new int[3];
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(arr[i]) || Character.getNumericValue(arr[i]) == 0) {
                throw new IllegalArgumentException("입력이 1~9로 이루어진 숫자가 아닙니다.");
            }
            userInput[i] = Character.getNumericValue(arr[i]);
        }
        return userInput;
    }

    public void checkNumbers() {

    }

    public boolean wantContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (readLine().equals("1")) {
            return true;
        } else if(readLine().equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
