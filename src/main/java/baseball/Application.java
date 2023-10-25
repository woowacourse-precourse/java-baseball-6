package baseball;

import baseball.startProcess.*;
import baseball.finishProcess.*;
import baseball.gameProcess.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameRole gameRole = new GameRole();

        StartProcess startProcess;
        InProcess inProcess;

        while (true) {
            startProcess = new StartProcess(gameRole);

            List<Integer> computer = startProcess.getComputerNumber();

            while (true) {
                inProcess = new InProcess(gameRole, computer);
                if (inProcess.isNumberCorrect()) break;
            }

            FinishProcess finishProcess = new FinishProcess();
            if (finishProcess.isExitGame()) break;
        }
    }
}
