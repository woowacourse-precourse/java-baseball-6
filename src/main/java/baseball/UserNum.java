package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserNum {

    List<Integer> numArr = new ArrayList<>();

    public List inputNum() {

        System.out.print("숫자를 입력해주세요 : ");

        StringTokenizer st = new StringTokenizer(Console.readLine());
        String userNum = st.nextToken(); //String 형태로 받기
        validateUserNum(userNum);

        for (Character c : userNum.toCharArray()) {
            numArr.add(Integer.parseInt(c.toString()));
        }

        return numArr;

    }

    public void validateUserNum(String userNum) {
        if (!isValidSize(userNum)) {
            throw new IllegalArgumentException("입력한 수가 세자리수가 아닙니다.");
        }
        if (zeroExist(userNum)) {
            throw new IllegalArgumentException("입력한 수에 0이 있으므로 수 범위를 벗어납니다.");
        }
        if (!isNumeric(userNum)) {
            throw new IllegalArgumentException("숫자 외에 다른 형태의 값을 입력할 수 없습니다.");
        }
        if (isDuplicated(userNum)) {
            throw new IllegalArgumentException("입력한 수에 중복된 수가 있습니다.");
        }

    }

    public boolean isValidSize(String input) {
        if (input.length() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean zeroExist(String input) {
        boolean Flag = false; // 기본 값

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                return true;
            }
        }
        return Flag;
    }

    public boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isDuplicated(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
