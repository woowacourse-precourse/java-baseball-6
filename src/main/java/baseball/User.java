package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> userNumberList() {
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요: ");
        String s = Console.readLine();

        if (s.length() > 3) {
            throw new IllegalArgumentException();
        }

        for (int x = 0; x < s.length(); x++) {
            int i1 = Integer.parseInt(String.valueOf(s.charAt(x)));
            if (i1 < 1 || i1 > 9) {
                throw new IllegalArgumentException();
            }
            user.add((int) s.charAt(x) - 48);
        }
        return user;
    }
}
