package baseball.controller;

import baseball.view.AskView;

public class AskController {

    public static void askNumberInput() {
        AskView.askNumberInput();
    }

    public static void askResumeInputWithOption(final int restart, final int end) {
        AskView.askResume(restart, end);
    }
}
