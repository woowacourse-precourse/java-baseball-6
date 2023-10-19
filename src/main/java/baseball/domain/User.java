package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private List<Integer> baseballNumberList;


    public List<Integer> getBaseballNumberList() {
        return baseballNumberList;
    }

    public void readBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String baseBallNumberStr = Console.readLine();

        validateBaseballNumber(baseBallNumberStr);
        convertCharToInteger(baseBallNumberStr);

    }

    private void convertCharToInteger(String baseBallString) {
        ArrayList<Integer> baseballNumbers = new ArrayList<>();

        for (char baseballChar : baseBallString.toCharArray())
            if (Character.isDigit(baseballChar) && Character.getNumericValue(baseballChar) != 0)
                baseballNumbers.add(Character.getNumericValue(baseballChar));

        if (baseballNumbers.size() != 3)
            throw new IllegalArgumentException();

        this.baseballNumberList = baseballNumbers;
    }

    private void validateBaseballNumber(String baseBallNumberStr) {
        if (baseBallNumberStr.chars().distinct().count() != 3)
            throw new IllegalArgumentException();
    }


}
