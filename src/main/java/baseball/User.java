package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    public List<Integer> inputNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String[] numbers = Console.readLine().split("");
        for(int i=0;i<numbers.length;i++) {
            user.add(Integer.parseInt(numbers[i]));
        }
        return user;
    }
}