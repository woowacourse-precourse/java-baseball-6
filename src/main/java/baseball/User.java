package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> user;

    public List<Integer> inputNumber() {
        this.user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String[] numbers = Console.readLine().split("");
        for(int i=0;i<numbers.length;i++) {
            this.user.add(Integer.parseInt(numbers[i]));
        }
        return user;
    }
}