package baseball;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private List<Integer> numberList;

    private Number() {
    }

    public static Number create(String input) {
        validateInput(input);

        Number number = new Number();
        number.setNumberList(input);

        return number;
    }

    public static Number create(List<Integer> numberList) {
        Number number = new Number();
        number.setNumberList(numberList);

        return number;
    }

    public void setNumberList(String input) {
        numberList = new ArrayList<>();
        int userInput = Integer.parseInt(input);
        int[] userArray = {userInput / 100, (userInput / 10) % 10, userInput % 10};
        for (int i = 0; i < 3; i++) {
            numberList.add(userArray[i]);
        }
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    private static void validateInput(String input) {
        Number.validateChangeNumber(input);
        Number.validateNumberSize(input);
        Number.validateDuplication(input);
    }

    private static void validateChangeNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    private static void validateNumberSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    private static void validateDuplication(String input) {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
                }
            }
        }
    }
}
