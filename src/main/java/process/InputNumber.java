package process;

import camp.nextstep.edu.missionutils.Console;
import validation.ValidationNumber;
import validation.ValidationStatus;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private InputNumber() {
    }

    public static InputNumber of() {
        return new InputNumber();
    }

    public List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return getNumbers(input);
    }

    public List<Integer> getNumbers(String input) {
        List<Integer> playerNumber = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            String str = String.valueOf(ch);
            int num = ValidationNumber.validationNumberType(str);
            playerNumber.add(num);
        }
        ValidationNumber.validateNumbers(playerNumber);
        return playerNumber;
    }

    public boolean getInputStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        int status = Integer.parseInt(s);
        ValidationStatus.ValidationStatus(status);
        if (status == 1) {
            return true;
        }
        return false;
    }


}
