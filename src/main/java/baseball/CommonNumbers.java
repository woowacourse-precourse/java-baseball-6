package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbers implements Numbers {
    private List<Integer> numContainer;

    /**
     * @param intStr should pass the validation check of Validator.
     *               intStr will be considered as a string of the following form:
     *               1. length of 3
     *               2. consists of only integers
     *               3. each integers range from 1 to 9
     *               4. no duplicate exists
     */
    public CommonNumbers(String intStr) {
        this.numContainer = extract(intStr);
    }

    private List<Integer> extract(String intStr) {
        String[] chars = intStr.split("");
        return Arrays.stream(chars).map(Integer::valueOf).toList();
    }

    @Override
    public int firstNumber() {
        return this.numContainer.get(0);
    }

    @Override
    public int secondNumber() {
        return this.numContainer.get(1);
    }

    @Override
    public int thirdNumber() {
        return this.numContainer.get(2);
    }

    @Override
    public List<Integer> allNumbers() {
        return new ArrayList<>(this.numContainer);
    }

    @Override
    public String toString() {
        return String.valueOf(this.numContainer.get(0)) + this.numContainer.get(1) + this.numContainer.get(2);
    }
}
