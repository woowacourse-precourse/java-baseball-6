package baseball.view;

import baseball.view.constants.StaticNotice;

public class OutputView {
    public static void printStaticNotice(StaticNotice notice) {
        System.out.print(notice.getMessage());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
