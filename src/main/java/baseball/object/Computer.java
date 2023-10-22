package baseball.object;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static String number;

    public Computer() {
        List<Integer> list = new ArrayList<>();

        int cnt = 3;
        while(cnt-- > 0) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber))
                list.add(randomNumber);
        }

        number = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String getNumber() {
        return number;
    }
}
