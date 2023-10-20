package baseball.view.input;

import baseball.dto.RetryDto;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class InputView {

    private static final String NUMBER_INPUT_REQUEST = "숫자를 입력해주세요 : ";
    private static final String RESTART_FORMAT = "1";
    private static final String EXIT_FORMAT = "2";
    private static final String RETRY_INPUT_REQUEST
            = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_FORMAT, EXIT_FORMAT);
    private static final Map<String, RetryDto> FORMAT_TO_RETRY_DTO
            = Map.of(RESTART_FORMAT, RetryDto.RESTART, EXIT_FORMAT, RetryDto.EXIT);

    public int readNumber() {
        print(NUMBER_INPUT_REQUEST);
        return readInt();
    }

    private int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    public RetryDto readWhetherToTry() {
        println(RETRY_INPUT_REQUEST);
        return readRetryDto();
    }

    private RetryDto readRetryDto() {
        String format = readLine();
        validateRetryFormat(format);

        return FORMAT_TO_RETRY_DTO.get(format);
    }

    private void validateRetryFormat(String format) {
        if (!FORMAT_TO_RETRY_DTO.containsKey(format)) {
            throw new IllegalArgumentException("재시도 여부는 형식에 맞추어 입력하여야 합니다");
        }
    }

    private String readLine() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
