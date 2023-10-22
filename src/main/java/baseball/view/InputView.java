package baseball.view;


public interface InputView {
    String inputBaseballNumber();

    String continueOrExit();

    boolean isContinue(String input);
}
