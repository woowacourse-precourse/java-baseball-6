package baseball.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserIo {

    public List<Integer> readNumbers() {
        return Arrays.stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public void print(String message) {
        System.out.print(message);
    }
}
