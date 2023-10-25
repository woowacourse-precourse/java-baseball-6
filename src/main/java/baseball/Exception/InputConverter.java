package baseball.Exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputConverter {

    public static List<Integer> convert(String player) {

        List<Integer> result = new ArrayList<>();

        for (char ch : player.toCharArray()) {
            try {
                result.add(Integer.parseInt(String.valueOf(ch)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력하세요");
            }
        }

        if (result.contains(0)) {
            throw new IllegalArgumentException("1~9 까지의 숫자를 입력하세요");
        }

        if (result.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요.");
        }

        Set<Integer> resultSet = new HashSet<>(result);

        if (resultSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력하세요.");
        }
        return result;
    }
}
