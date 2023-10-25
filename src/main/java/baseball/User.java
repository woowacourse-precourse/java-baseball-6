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

    public List<Integer> enterNumber() {
        numbers.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        if (checkInvalid(inputNum)) {
            throw new IllegalArgumentException();
        }
        return convertStrToList(inputNum);
    }

    // String -> List 변환
    private List<Integer> convertStrToList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < LEN_NUM; i++) {
            result.add((Integer.valueOf(input.substring(i, i + 1))));
        }
        return result;
    }

    // 각 자리 숫자 1-9 이외의 잘못된 입력 처리
    private boolean checkInvalid(String input) {
        if (input.length() != LEN_NUM) {
            return true;
        }
        if (!isDigitNumber(input)) {
            return true;
        }
        if (isDuplicate(input)) {
            return true;
        }

        return false;
    }

    private boolean isDuplicate(String input) {
        String first = input.substring(0, 1);
        String sec = input.substring(1, 2);
        String third = input.substring(2, 3);

        if (first.equals(sec) || first.equals(third) || sec.equals(third)) {
            return true;
        }
        return false;
    }

    // 각 자리 수가 숫자인지 판별
    private boolean isDigitNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            String digit = input.substring(i,i+1);
            if (!digit.matches("-?\\d+(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }


}