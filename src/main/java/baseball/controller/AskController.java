package baseball.controller;

import baseball.view.AskView;

public class AskController {

    public static void askNumberInput() {
        AskView.printAskNumber();
    }

    public static void askResumeInputWithOption(final int restart, final int end) {
        AskView.printAskResume(restart, end);
    }
}
