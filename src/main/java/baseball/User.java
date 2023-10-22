package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumber;

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberString = Console.readLine();
        numberStringToList(numberString);
        validateNumberDigits(userNumber);
        validateNumberUnique(userNumber);
    }

    private void numberStringToList(String number) {
        userNumber = new ArrayList<>();
        for (String digit : number.split("")) {
            userNumber.add(Integer.parseInt(digit));
        }
    }

    private void validateNumberDigits(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("number should be 3 digits");
        }
    }

    private void validateNumberUnique(List<Integer> userNumber) {
        if (userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException("each digits cannot be same with others");
        }
    }

    public String getHint(Computer computer) {
        return computer.getGameResult(userNumber);
    }
}
