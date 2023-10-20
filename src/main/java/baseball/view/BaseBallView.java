package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class BaseBallView {


    private BaseBallView() {
    }

    public static BaseBallView create() {
        return new BaseBallView();
    }

    public void startGameView() {
        ConsolePrint.printStart();
    }

    public void resultGameView(String result) {
        ConsolePrint.printResult(result);
    }


    public String numbersInputView() {
        ConsolePrint.printNumberInput();

        return readLine();
    }

    public String continueInputView() {
        ConsolePrint.printFinish();

        return readLine();
    }


}
