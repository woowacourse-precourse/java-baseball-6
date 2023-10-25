package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private String numbers;
    private List<Integer> numberList;

    public Input() {
        this.numbers = Console.readLine();

        if (this.numbers.length() != 3) {
            throw new IllegalArgumentException();
        } else if (!this.numbers.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }

        this.setNumberList(numbers);
    }

    public String getNumbers() {
        return this.numbers;
    }

    private void setNumberList(String numbers) {
        String[] inputArr = numbers.split("");
        this.numberList = Arrays.stream(inputArr).map(Integer::parseInt).toList();
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }
}
