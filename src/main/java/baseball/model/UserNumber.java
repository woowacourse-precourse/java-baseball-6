package baseball.model;

import static baseball.util.StringtoList.changeStringtoList;

import java.util.List;

public class UserNumber {
    private List<Integer> inputNumber;

    public UserNumber(String inputNumber) {
        this.inputNumber = changeStringtoList(inputNumber);
    }

    public List<Integer> getInputNumber() {
        return this.inputNumber;
    }
}
