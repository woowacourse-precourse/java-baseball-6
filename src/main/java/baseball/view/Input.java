package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void scannerClose() {
        Console.close();
    }

    public static int[] getIntegerArrayFromString(String userInput) {
        int[] userNum = new int[3];
        for (int i = 0; i < userNum.length; i++) {
            userNum[i] = Character.getNumericValue(userInput.charAt(i));
        }
        return userNum;
    }
}
