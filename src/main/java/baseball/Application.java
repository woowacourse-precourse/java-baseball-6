package baseball;

import baseball.startProcess.*;
import baseball.finishProcess.*;
import baseball.gameProcess.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            // 게임 설정 세팅
            GameSetting gameSetting = new GameSetting();

            // 게임 시작
            StartProcess startProcess = new StartProcess(gameSetting);

            while (true) {
                // 게임 진행
                while (true) {
                    InProcess inProcess = new InProcess(gameSetting, startProcess.getComputerNumber());
                    if (inProcess.isNumberCorrect()) break;
                }

                // 게임 끝
                FinishProcess finishProcess = new FinishProcess();
                if (!finishProcess.isContinueGame()) break;

                startProcess.resetGame(gameSetting);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
