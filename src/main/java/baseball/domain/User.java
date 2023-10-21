package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.validation.BaseballGameValidation;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private String baseBallNumberString;
    private BaseballGameValidation baseballGameValidation;

    public User() {
        this.baseballGameValidation = new BaseballGameValidation();
    }

    public String getBaseballNumberList() {
        return baseBallNumberString;
    }

    public void readBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        baseBallNumberString = Console.readLine();

    }
    public List<Integer> convertCharToInteger(String baseBallString) {
        ArrayList<Integer> baseballNumbers = new ArrayList<>();

        for (char baseballChar : baseBallString.toCharArray())
            if (Character.isDigit(baseballChar) && Character.getNumericValue(baseballChar) != 0)
                baseballNumbers.add(Character.getNumericValue(baseballChar));

        baseballGameValidation.checkBaseballNumberSize(baseballNumbers);

        return baseballNumbers;
    }


}
