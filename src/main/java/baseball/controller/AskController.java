package baseball.controller;

import static baseball.Constants.END_WANT;
import static baseball.Constants.PLAY_WANT;

import baseball.view.AskView;

public class AskController {

    public static void askNumberInput() {
        AskView.printAskNumber();
    }

    public static void askResumeInput() {
        AskView.printAskResume(PLAY_WANT, END_WANT);
    }
}
