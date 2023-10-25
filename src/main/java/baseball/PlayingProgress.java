package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayingProgress {
    public void streamGame() {
        ComputerNum computerNum = new ComputerNum();
        List<Integer> listComFixed = new ArrayList<>(computerNum.computer());

        CheckingAnswerProcess checkingAnswerProcess = new CheckingAnswerProcess();
        checkingAnswerProcess.checkingStream(listComFixed);
    }

    public void gameLoop() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        int newGame = 1;

        do {
            streamGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newGame = continueOrNot();
        } while (newGame == 1);
    }

    public int continueOrNot() {

        String gameOrNot = Console.readLine();
        int newOrEnd = Integer.parseInt(gameOrNot);

        if(newOrEnd != 1 && newOrEnd !=2) {
            throw new IllegalArgumentException();
        }
        return newOrEnd;
    }
}
