package baseball;

import baseball.startProcess.*;
import baseball.finishProcess.*;
import baseball.gameProcess.*;

public class Application {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();

        StartProcess startProcess;
        InProcess inProcess;
        FinishProcess finishProcess = new FinishProcess();

        while (finishProcess.isContinueGame()) {
            startProcess = new StartProcess(gameRole);

            inProcess = new InProcess(gameRole, startProcess.getComputerNumber());
            while (inProcess.isNumberCorrect()) {
                inProcess = new InProcess(gameRole, startProcess.getComputerNumber());
            }

            finishProcess = new FinishProcess();
        }
    }
}
