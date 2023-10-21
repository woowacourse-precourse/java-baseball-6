package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class user {
    private final List<Integer> numbers = new ArrayList<>();

    private void getNum() {
        String getNumber;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            getNumber = br.readLine();
            getNumberError(getNumber);
        } catch (Exception e) {
        }
    }

    private void getNumberError(String getNumber) {
        if (numOverLength(getNumber)) {
            throw new IllegalArgumentException("입력한 값이 세자리 수가 아닙니다.");
        } else if (notNum(getNumber)) {
            throw new IllegalArgumentException("입력한 값에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private boolean numOverLength(String getNum) {
        return (getNum.length() != 3);
    }
    private boolean notNum(String getNum) {
        int numbers = Integer.parseInt(getNum);
        return (numbers / 1000 != 0);
    }
}
