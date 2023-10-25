package baseball.view;

import static baseball.constant.MsgConstant.*;

public class UserView {
    public static void requestInput() {
        System.out.print(START_MSG);
    }

    public static void requestReply() {
        System.out.println(ALL_STRIKE);
        System.out.println(AFTER_SUCCESS);
    }
}
