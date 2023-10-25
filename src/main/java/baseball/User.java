package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int LEN_NUM = 3;

    private List<Integer> numbers;

    public User() {
        numbers = new ArrayList<>();
    }

    public void enterNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        if (checkInvalid(inputNum)) {
            throw new IllegalArgumentException();
        }
        numbers = convertStrToList(inputNum);
    }

    // String -> List 변환
    private List<Integer> convertStrToList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < LEN_NUM; i++) {
            result.add((int) input.charAt(i));
        }
        return result;
    }


}