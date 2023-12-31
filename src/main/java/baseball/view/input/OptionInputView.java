package baseball.view.input;

import baseball.dto.OptionRequestDto;
import camp.nextstep.edu.missionutils.Console;

public class OptionInputView {

    public static OptionRequestDto readOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return toDto(Console.readLine());
    }

    private static OptionRequestDto toDto(String input) {
        OptionRequestDto optionRequestDto = new OptionRequestDto();
        optionRequestDto.setNumber(validateNumberFormat(input));
        return optionRequestDto;
    }

    private static int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
