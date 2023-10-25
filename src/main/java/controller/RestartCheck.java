package controller;

import view.InputView;

public class RestartCheck {
    public static boolean offerRestartOrQuit() {
        String input = InputView.setRestartNumber();

        isValidNumber(input);
        return input.equals("1");
    }

    public static void isValidNumber(String restartCheckInput) {
        if (!restartCheckInput.equals("1") && !restartCheckInput.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

}
