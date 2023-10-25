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
    public static void printResult(int[] score) {
        outputConsole.printResultMsg(score[0], score[1]);
    }

    public boolean getReplaymanual() {
        outputConsole.printReplayMsg();
        return InputConsole.userReplayInputSetting() == 1;
    }

    public void userNumSetting(String str) {
        InputConsole.userNumSetting(str);
    }

    public static int[] userNumGetting() {
        return InputConsole.userNumGetting();
    }

    public static int userReplayInputSetting() {
        return InputConsole.userReplayInputSetting();
    }

    public static int[] computerNumSetting() {
        return InputConsole.computerNumSetting();
    }

}
