package baseball.dto.request;

import baseball.common.exception.input.InputErrorCode;
import baseball.common.exception.input.InputException;

import static baseball.common.config.GameConfig.END_ANSWER;
import static baseball.common.config.GameConfig.RESTART_ANSWER;

public class RestartAnswerRequest {
    private final String answer;

    public RestartAnswerRequest(final String answer) {
        checkAnswer(answer);
        this.answer = answer;
    }

    private void checkAnswer(String answer) {
        if (!answer.equals(RESTART_ANSWER) && !answer.equals(END_ANSWER)) {
            throw new InputException(InputErrorCode.INVALID_CONTINUE_ANSWER);
        }
    }

    public String getAnswer() {
        return answer;
    }
}
