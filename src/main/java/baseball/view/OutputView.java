package baseball.view;

import static baseball.model.message.ErrorMessage.DO_NOT_CALL_THIS_CODE;
import static baseball.model.message.UserMessage.ASK_REPLAY_MESSAGE;
import static baseball.model.message.UserMessage.DONE_MESSAGE;
import static baseball.model.message.UserMessage.INPUT_GUIDE_MESSAGE;
import static baseball.model.message.UserMessage.START_MASSAGE;

import baseball.model.Result;

public class OutputView {

    private OutputView() {
        throw new AssertionError(DO_NOT_CALL_THIS_CODE.getMessage());
    }

    public static void printStartMessage() {
        System.out.println(START_MASSAGE);
    }

    public static void printInputGuideMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE);
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printDoneMessage() {
        System.out.println(DONE_MESSAGE);
        System.out.println(ASK_REPLAY_MESSAGE);
    }
}
