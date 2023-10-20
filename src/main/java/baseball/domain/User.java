package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private String baseBallNumberString;


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

        checkBaseballNumberSize(baseballNumbers);

        return baseballNumbers;
    }

    public void checkBaseballNumberSize(ArrayList<Integer> baseballNumbers) {
        if (baseballNumbers.size() != 3)
            throw new IllegalArgumentException();
    }

    public void validateBaseballNumber(String baseBallNumberStr) {
        if (baseBallNumberStr.chars().distinct().count() != 3)
            throw new IllegalArgumentException();
    }


}
