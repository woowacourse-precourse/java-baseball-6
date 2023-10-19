package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    // 시작문구를 출력하는 기능
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 사용자의 숫자입력을 알리는 기능
    public void printUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public String numberInput() {
        String input_number = Console.readLine();

        return input_number;
    }

    public int[] stringToIntArray(String input) {
        int[] intArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            intArray[i] = digit;
        }
        return intArray;
    }

    public static void main(String[] args) {


    }
}
