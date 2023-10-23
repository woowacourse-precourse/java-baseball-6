package baseball.view;

import static baseball.model.MsgConstant.AFTER_SUCCESS;
import static baseball.model.MsgConstant.ALL_STRIKE;
import static baseball.model.MsgConstant.START_MSG;

public class UserView {
    public static void requestInput() {
        System.out.print(START_MSG);
    }

    public static void requestReply() {
        System.out.println(ALL_STRIKE);
        System.out.println(AFTER_SUCCESS);
    }
}
