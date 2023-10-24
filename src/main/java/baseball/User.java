package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String RESTART_INPUT = "1";
    private static final String EXIT_INPUT = "2";

    public List<Integer> getNumbersFromUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumbersFromUser(input);
        return convertStringToIntList(input);
    }

    public void validateNumbersFromUser(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이가 올바르지 않습니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
        if (hasDuplicates(input)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public boolean hasDuplicates(String str) {
        return str.length() != str.chars().distinct().count();
    }

    public List<Integer> convertStringToIntList(String input) {
        List<Integer> numberList = new ArrayList<>();
        String[] split = input.split("");
        for (String number : split) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!(input.equals(RESTART_INPUT) || input.equals(EXIT_INPUT))) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
        return input.equals(RESTART_INPUT);
    }
}
