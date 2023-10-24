package baseball.console;

public class MainController {
    private final InputConsole inputConsole;
    private static OutputConsole outputConsole;

    public MainController(InputConsole inputConsole, OutputConsole outputConsole) {
        this.inputConsole = inputConsole;
        this.outputConsole = outputConsole;
    }

    public static void printStartingGame() {
        outputConsole.printStartingMsg();
    }
    public void printInputValue() {
        outputConsole.printInputMsg();
    }
    public void printFinish() {
        outputConsole.printAllClearMsg();
    }
    public void printReplay() {
        outputConsole.printReplayMsg();
    }
    public void printResult(int[] score) {
        outputConsole.printResultMsg(score[0], score[1]);
    }

    public boolean getReplaymanual() {
        outputConsole.printReplayMsg();
        return InputConsole.userReplayInputSetting() == 1;
    }

}
