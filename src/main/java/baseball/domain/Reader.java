package baseball.domain;

import static baseball.domain.MessageConstants.ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class Reader {
    List<Integer> readThreeNumbers() {
        try {
            String[] input = Console.readLine().split("");
            return Arrays.stream(input).map(Integer::parseInt).toList();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ERROR_MESSAGE, ex);
        }
    }

    Integer readOneNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception ex) {
            throw new IllegalArgumentException(ERROR_MESSAGE, ex);
        }
    }
}
