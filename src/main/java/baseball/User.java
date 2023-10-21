package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Integer> userNumber;

    public void writeNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        int number = Integer.parseInt(Console.readLine());
        numberToList(number);
        validateNumber(userNumber);
    }

    public void numberToList(int number) {
        userNumber = new ArrayList<>();
        userNumber.add(number / 100);
        userNumber.add((number % 100) / 10);
        userNumber.add((number % 100) % 10);
    }

    public static void validateNumber(List<Integer> userNumber) {
        if(userNumber.get(0) > 9 || userNumber.get(0) < 1) {
            throw new IllegalArgumentException("numbers are should be 3 digits");
        }
        if(userNumber.size() != userNumber.stream().distinct().count()) {
            throw new IllegalArgumentException("each digits cannot be same with others");
        }
    }

    public String getHint(Computer computer) {
        return computer.playGame(userNumber);
    }
}
