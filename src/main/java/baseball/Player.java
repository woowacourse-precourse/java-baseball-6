package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public List<Integer> readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String read = Console.readLine().strip();
        validateCount(read);
        validateIsNumeric(read);
        List<Integer> numbers = toIntegerList(read);
        validateUniqueNumbers(numbers);
        validateRange(numbers);
        return numbers;
    }

    public int askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String read = Console.readLine();
        validateRestartCommand(read);
        return Integer.parseInt(read);
    }

    private List<Integer> toIntegerList(String str) {
        List<Integer> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }

    private void validateRestartCommand(String command) {
        if (command.equals("1") || command.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("1또는 2만 입력해야 합니다");
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

    private void validateRange(List<Integer> numbers) {
        for (int num: numbers) {
            if (1 > num || num > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        for (int num: numbers) {
            if (Collections.frequency(numbers, num) != 1) {
                throw new IllegalArgumentException("숫자 3개가 서로 달라야 합니다.");
            }
        }
    }
}
