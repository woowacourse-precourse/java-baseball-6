package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int optionNum = 0;

    public String getNum() {
        String number = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            number = br.readLine();
            getNumberError(number);
        } catch (Exception e) {
        }
        return number;
    }

    public void getNumberError(String getNumber) {
        if (numOverLength(getNumber)) {
            throw new IllegalArgumentException("입력한 값이 세자리 수가 아닙니다.");
        } else if (notNum(getNumber)) {
            throw new IllegalArgumentException("입력한 값에 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    public boolean numOverLength(String getNum) {
        return (getNum.length() != 3);
    }
    public boolean notNum(String getNum) {
        int numbers = Integer.parseInt(getNum);
        return (numbers / 1000 != 0);
    }

    public int getOptionNum() {
        String getOption;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            getOption = br.readLine();
            optionNum = Integer.parseInt(getOption);
        } catch (Exception e) {
        }
        return optionNum;
    }

    public boolean option(int optionNum) {
        if (optionNum == 1) {
            return true;
        } else if (optionNum == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("입력한 값이 1 또는 2가 아닙니다.");
        }
    }
}
