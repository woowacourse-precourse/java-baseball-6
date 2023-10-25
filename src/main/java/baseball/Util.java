package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static String getArgument() {
        String str = Console.readLine().trim();

        if (str.contentEquals("1") || str.contentEquals("2")) {
            return str;
        }
        throw new IllegalArgumentException("1 혹은 2만 입력하세요!");
    }


    public static List<Integer> getNumber() {
        String str = Console.readLine().trim();
        List<Integer> list = new ArrayList<>();

        boolean[] check = new boolean[10];
        Error.illegalInputSize(str);

        for (char c : str.toCharArray()) {
            Error.illegalInputRange(c);
            Error.duplicateInput(check, c);
            check[c - '0'] = true;
            list.add(c - '0');
        }
        return list;
    }

    private static void addRandomNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    public static void getRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Util.addRandomNumber(computer, randomNumber);
        }
    }
}
