package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> inputPlayerNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        return validPlayerNumbers(inputNumbers);
    }

    private static List<Integer> validPlayerNumbers(String inputNumbers) {

        if (inputNumbers.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다. 3자리의 숫자를 입력해주세요.");
        }

        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자만 입력 가능합니다.");
        }

        List<Integer> playerNumbers = new ArrayList<>();

        inputNumbers.chars().forEach(c -> {
            int num = Character.getNumericValue(c);
            if (!(c >= '1' && c <= '9')) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
            }
            if (playerNumbers.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
            }
            playerNumbers.add(num);
        });

        return playerNumbers;
    }
}
