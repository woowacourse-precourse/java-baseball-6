package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        ValidationUtils.validateUnique3DigitNum(input);
        List<Integer> list = new ArrayList<>();
        for (String s : input.split("")) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public static int getUserGameAction() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        ValidationUtils.validateOneOrTwo(input);
        return Integer.parseInt(input);
    }
}
