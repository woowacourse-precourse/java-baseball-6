package process;

import camp.nextstep.edu.missionutils.Console;
import validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumberProcess {
    private List<Integer> inputNumber;

    private PlayerNumberProcess(List<Integer> inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static PlayerNumberProcess getInstance(List<Integer> inputNumber) {
        return new PlayerNumberProcess(inputNumber);
    }

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return getNumbers(input);
    }

    public List<Integer> getNumbers(String input) {
        inputNumber = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            String str = String.valueOf(ch);
            int num = ValidationNumber.validationNumberType(str);
            inputNumber.add(num);
        }
        ValidationNumber.validateNumbers(inputNumber);
        return inputNumber;
    }


}
