package baseball.model;

import baseball.utils.BaseballStringUtils;
import baseball.utils.Validator;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberList {
    private static final int BASEBALL_NUMBER_LIST_LENGTH = 3;
    private List<BaseballNumber> baseballNumberList = new ArrayList<>();

    public void setRandomBaseballNumberList() {
        while (baseballNumberList.size() != BASEBALL_NUMBER_LIST_LENGTH) {
            BaseballNumber randomBaseballNumber = BaseballNumber.getRandomBaseballNumber();
            if (!baseballNumberList.contains(randomBaseballNumber)) {
                baseballNumberList.add(randomBaseballNumber);
            }
        }
    }

    public void setBaseballNumberList(String baseballNumberListString) {
        validateBaseballNumberListString(baseballNumberListString);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (String baseballNumberString : baseballNumberListString.split(BaseballStringUtils.EMPTY_STRING)) {
            int baseballNumberInt = Integer.parseInt(baseballNumberString);
            BaseballNumber baseballNumber = new BaseballNumber(baseballNumberInt);
            baseballNumbers.add(baseballNumber);
        }
    }

    public static void validateBaseballNumberListString(String baseballNumberListString) {
        Validator.validateInputEmptyOrNull(baseballNumberListString);
        Validator.validateInputLength(baseballNumberListString, BASEBALL_NUMBER_LIST_LENGTH);
        Validator.validateInputDistinct(baseballNumberListString);
        Validator.validateInputDigit(baseballNumberListString);
    }
}
