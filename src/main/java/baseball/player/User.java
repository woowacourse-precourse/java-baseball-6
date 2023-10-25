package baseball.player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public int[] inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String Line = readLine();
        int[] arr = toIntArray(Line);
        return arr;
    }

    private int[] toIntArray(String str) {
        char[] arr = str.toCharArray();
        if (arr.length != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
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

    public boolean wantContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = readLine();
        if (line.equals("1")) {
            return true;
        } else if(line.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
