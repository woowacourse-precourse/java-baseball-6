package baseball.controller;

import static baseball.view.InputView.userInput;
import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.printCelebrate;
import static baseball.view.OutputView.userInputMessage;

import baseball.Application;
import baseball.model.BallStrikeCounter;
import baseball.model.ComputerNumber;
import baseball.model.RetryCheck;
import baseball.model.UserNumber;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;


public class BaseballGame {
    private final BallStrikeCounter ballStrikeCounter = new BallStrikeCounter();
    private List<Integer> computerNumber;

    public BaseballGame() {
        this.computerNumber = new ArrayList<>();
    }

    public void gameStart() {

        // 게임 초기 설정
        ballStrikeCounter.resetBallStrike();

        // 랜덥 값 생성
        computerNumber = ComputerNumber.makeComputerNumber();

        // 게임 시작 메시지 출력
        gameStartMessage();
    }

    public void inGame() {
        while (true) {
            // 사용자 값 입력
            userInputMessage();
            UserNumber userNumber = new UserNumber(userInput());

            // 볼, 스트라이크 카운트
            ballStrikeCounter.countBallStrike(userNumber.getInputNumber(), computerNumber);

            // 볼, 스트라이크 값 출력
            OutputView.printBallStrike(ballStrikeCounter.toString());

            // 3스트라이크 시 while 종료
            if (ballStrikeCounter.isThreeStrike()) {
                break;
            }

            //볼, 스트라이크 카운트 초기화
            ballStrikeCounter.resetBallStrike();
        }

        printCelebrate();
    }

    public void retryCheck() {
        RetryCheck retryCheck = new RetryCheck(userInput());

        if (retryCheck.isRetry()) {
            Application.main(new String[]{});
        }
    }
}
