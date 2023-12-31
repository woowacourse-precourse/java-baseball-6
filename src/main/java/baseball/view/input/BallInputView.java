package baseball.view.input;

import baseball.dto.BallRequestDto;
import camp.nextstep.edu.missionutils.Console;

public class BallInputView {

    public static BallRequestDto readBall() {
        System.out.print("숫자를 입력해주세요 : ");
        return toDto(Console.readLine());
    }

    private static BallRequestDto toDto(String input) {
        BallRequestDto ballRequestDto = new BallRequestDto();
        ballRequestDto.setNumber(validateNumberFormat(input));
        return ballRequestDto;
    }

    private static int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
