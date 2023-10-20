package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Inputview {

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> input() {
        System.out.print("숫자를 입력해주세요: ");
        String inputString = Console.readLine();

        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char charDigit = inputString.charAt(i);
            int intDigit = Character.getNumericValue(charDigit);
            numberList.add(intDigit);
        }

        return numberList;
    }

}
