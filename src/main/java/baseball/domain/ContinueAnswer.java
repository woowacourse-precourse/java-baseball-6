package baseball.domain;

import baseball.validator.Validator;

import static baseball.domain.Const.*;

public class ContinueAnswer {

    private final Validator validator = new Validator();
    private int answer;

    public void createAnswer(String answerString) {
        int parsedValidatedInt = validator.parseValidatedInt(answerString);
        validator.validateCiphers(parsedValidatedInt, CONTINUE_ANSWER_CIPHER);
        validator.validateInRange(parsedValidatedInt, CONTINUE_ANSWER, EXIT_ANSWER);
        answer = parsedValidatedInt;
    }

    public boolean ifContinue() {
        return answer == CONTINUE_ANSWER;
    }
}
