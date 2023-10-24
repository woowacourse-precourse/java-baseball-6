package baseball.model;

import static baseball.model.Constant.NUMBER_RANGE_END;
import static baseball.model.Constant.NUMBER_RANGE_START;
import static baseball.model.Constant.NUMBER_SIZE;

import baseball.controller.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecimalNumber {

    private List<Integer> computer;
    private List<Integer> user;

    public List<Integer> getComputer() {
        return computer;
    }

    public void setComputer() {
        this.computer = generateRandomNum();
    }

    public List<Integer> getUser() {
        return user;
    }

    public void setUser(String input) {
        Validation.validationGameNumber(input);
        this.user = stringToList(input);
    }

    private List<Integer> generateRandomNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> stringToList(String input) {
        String[] strArr = input.split("");
        Integer[] intArr = new Integer[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        List<Integer> result = new ArrayList<>(Arrays.asList(intArr));

        return result;
    }
}
