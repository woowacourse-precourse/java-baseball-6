package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> userNumber;

    public void setUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요.");
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(number/100);
        numbers.add(number/10%10);
        numbers.add(number%10);

        this.userNumber = numbers;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
