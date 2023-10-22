package baseball.view;

import static baseball.model.MsgConst.AFTER_SUCCESS;
import static baseball.model.MsgConst.ALL_STRIKE;
import static baseball.model.MsgConst.START_MSG;

public class UserView {
    public static void requestInput() {
        System.out.print(START_MSG);
    }

    public static void requestReply() {
        System.out.println(ALL_STRIKE);
        System.out.println(AFTER_SUCCESS);
    }
}
