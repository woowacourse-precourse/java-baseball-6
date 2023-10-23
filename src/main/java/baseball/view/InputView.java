package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int INPUT_NUMBER_SIZE = 3;
    public static final int GAME_RESTART_NUMBER = 1;

    private List<Integer> inputNumber = new ArrayList<>();

    public List<Integer> inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        inputNumber = integerNumber(List.of(Console.readLine().split("")));
        validationNotSize();

        return inputNumber;
    }

    // 숫자 사이즈 검사
    private void validationNotSize() {
        duplicateValidationNumber();

        if (inputNumber.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자 중복 검사
    private void duplicateValidationNumber() {
        Set<Integer> setNumber = new HashSet<>(inputNumber);

        if (setNumber.size() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> integerNumber(List<String> stringNumber) {
        return stringNumber.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public boolean restartCheck() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RE_GAME_MESSAGE);

        return Integer.parseInt(Console.readLine()) == GAME_RESTART_NUMBER;
    }
}
