package baseball.domain;

import baseball.validator.Validator;

import static baseball.domain.Const.*;

public class ContinueAnswer {
    private int answer;

    public void createAnswer(String answerString) {
        int parsedValidatedInt = Validator.parseValidatedInt(answerString);
        Validator.validateCiphers(parsedValidatedInt, CONTINUE_ANSWER_CIPHER);
        Validator.validateInRange(parsedValidatedInt, CONTINUE_ANSWER, EXIT_ANSWER);
        answer = parsedValidatedInt;
    }

    public boolean ifContinue() {
        return answer == CONTINUE_ANSWER;
    }
}