package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public List<Integer> readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String read = Console.readLine().strip();
        validateCount(read);
        validateIsNumeric(read);

        List<Integer> numbers = new ArrayList<>();
        for (char c: read.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    public int askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String read = Console.readLine();
        return Integer.parseInt(read);
    }

    private void validateCount(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해야 합니다.");
        }
    }

    private void validateIsNumeric(String read) {
        for (char c: read.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }
}
