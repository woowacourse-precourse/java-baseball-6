package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private final ValidationUtils validationUtils = new ValidationUtils();
    public List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validationUtils.validateUnique3DigitNum(input);
        List<Integer> list = new ArrayList<>();
        for (String s : input.split("")) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    public int getUserGameAction() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validationUtils.validateOneOrTwo(input);
        return Integer.parseInt(input);
    }
}
