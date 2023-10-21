package baseball.controller;

import static baseball.view.InputView.userInput;
import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.printCelebrate;
import static baseball.view.OutputView.userInputMessage;

import baseball.model.ComputerNumber;
import baseball.model.RetryCheck;
import baseball.model.UserNumber;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;


public class BaseballGame {
    private List<Integer> computerNumber;
    private int[] cntBallStrike;

    public BaseballGame() {
        this.cntBallStrike = new int[2];
        this.computerNumber = new ArrayList<>();
    }

    public void gameStart() {
        this.cntBallStrike = new int[2];

        gameStartMessage();

        //랜덥 값 생성
        computerNumber = ComputerNumber.makeComputerNumber();

        //게임 시작
        inGame();

        //재시작 여부 입력
        retryCheck();
    }

    public void inGame() {
        while (cntBallStrike[1] != 3) {
            //사용자 값 입력
            userInputMessage();
            UserNumber userNumber = new UserNumber(userInput());

            //볼, 스트라이크 카운트
            this.countBallStrike(userNumber.getInputNumber(), computerNumber);

            //볼, 스트라이크 값 출력
            OutputView.printBallStrike(cntBallStrike[0], cntBallStrike[1]);

            //볼, 스트라이크 카운트 초기화
            cntBallStrike[0] = 0;
            cntBallStrike[1] = 0;
        }

        printCelebrate();
    }

    public void countBallStrike(List<Integer> userNumber, List<Integer> computerNumber) {

        for (int i = 0; i < userNumber.size(); i++) {

            if (userNumber.get(i).equals(computerNumber.get(i))) {
                cntBallStrike[1]++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                cntBallStrike[0]++;
            }

        }

    }

    public void retryCheck() {
        RetryCheck retryCheck = new RetryCheck(userInput());

        if (retryCheck.getNum().equals("1")) {
            this.gameStart();
        }

        /*if (retryCheck.getNum().equals("2")) {

        }*/
    }
}
