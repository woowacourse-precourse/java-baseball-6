package baseball.hint;

import baseball.constant.StatusMessage;
import baseball.counter.CounterValidator;

public class Message {
    public static String getMessage(int count, StatusMessage statusMessage) {
        return CounterValidator.isValidCount(count)
                .map(c -> c + statusMessage.statusName)
                .orElse("");  // count가 0인 경우 빈 문자열 반환
    }
}
