package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private Validate validate;

    Input() {
        this.validate = new Validate();
    }

    List<Integer> getNumber() {
        String number = Console.readLine();

        validate.validateInput(number);
        return toArrayList(number);
    }

    List<Integer> toArrayList(String number) {
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            inputNumber.add(number.charAt(i) - '0');
        }
        return inputNumber;
    }
}
