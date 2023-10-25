package baseball;

import baseball.startProcess.*;
import baseball.finishProcess.*;
import baseball.gameProcess.*;

public class Application {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();

        StartProcess startProcess = new StartProcess(gameRole);
        InProcess inProcess;
        FinishProcess finishProcess;

        try {
            while (true) {
                while (true) {
                    inProcess = new InProcess(gameRole, startProcess.getComputerNumber());
                    if (inProcess.isNumberCorrect()) break;
                }

                finishProcess = new FinishProcess();
                if (!finishProcess.isContinueGame()) break;

                startProcess.resetGame(gameRole);
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}
