package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    List<Integer> readPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();
        try {
            Validator.validateNumber(player);
            return makeNumberArray(player);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> makeNumberArray(String player) {
        int number = Integer.parseInt(player);
        int n1, n2, n3;
        n1 = number / 100;
        n2 = number % 100 / 10;
        n3 = number % 10;
        Integer[] numberArray = {n1, n2, n3};
        Validator.duplicated(numberArray);
        List<Integer> playerNum = Arrays.asList(numberArray);
        return playerNum;
    }
}
