package baseball.View;

import baseball.validator.NumValidator;
import baseball.validator.RestartNumValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class inputView {

    // 사용자 숫자 입력 처리 (인스턴스 메서드로 변경)
    public List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        NumValidator.validateLength(input);
        NumValidator.ValidateIsNumeric(input);
        NumValidator.ValidateDuplication(input);
        NumValidator.validateIsInRange(input);

        List<Integer> numbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }
        return numbers;
    }

    // 게임 재실행 여부 입력 처리
    public boolean readRestartNumber() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String choice = Console.readLine();
        RestartNumValidator.validateRestartNum(choice);
        return "1".equals(choice);
    }
}
