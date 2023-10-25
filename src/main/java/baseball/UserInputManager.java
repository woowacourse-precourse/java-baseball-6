package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputManager {

    // 사용자 숫자 입력 처리 함수
    // 입력 검증 후 올바른 입력시 생성된 숫자 리스트 반환
    // 입력이 올바르지 않을 경우 예외 발생
    public List<Integer> processNumberInput() {
        String line = Console.readLine();

        List<Integer> numbers = new ArrayList<>();

        for (String number : line.split("")) {
            numbers.add(Integer.valueOf(number));
        }

        // 입력한 숫자가 3개가 아니거나 중복이 있을 경우 예외 발생
        if (numbers.size() != 3 || numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        return numbers;
    }

    // 재시작 여부 선택 처리 함수
    // 입력 검증 후 재시작 여부 반환
    // 입력이 올바르지 않을 경우 예외 발생
    public boolean processRestartSelectionInput() {
        String selection = Console.readLine();

        // 입력값이 1 혹은 2가 아닐 경우 예외 발생
        if (!(selection.equals("1")|| selection.equals("2"))) {
            throw new IllegalArgumentException();
        }

        return selection.equals("1");
    }
}
