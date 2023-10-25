package baseball;

import baseball.startProcess.*;
import baseball.finishProcess.*;
import baseball.gameProcess.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        GameSetting gameSetting = new GameSetting();

        StartProcess startProcess = new StartProcess(gameSetting);
        InProcess inProcess;
        FinishProcess finishProcess;

        try {
            while (true) {
                while (true) {
                    inProcess = new InProcess(gameSetting, startProcess.getComputerNumber());
                    if (inProcess.isNumberCorrect()) break;
                }

                finishProcess = new FinishProcess();
                if (!finishProcess.isContinueGame()) break;

                startProcess.resetGame(gameSetting);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
