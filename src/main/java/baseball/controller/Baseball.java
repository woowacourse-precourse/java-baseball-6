package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.util.ComputeBallCount;
import baseball.util.CheckBallCount;
import baseball.util.ValidateNumber;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    OutputMessage outputMessage = new OutputMessage();
    InputMessage inputMessage = new InputMessage();
    ValidateNumber validateNumber = new ValidateNumber();
    ComputerNumber computerNumber = new ComputerNumber();
    ComputeBallCount computeBallCount = new ComputeBallCount();
    CheckBallCount checkBallCount = new CheckBallCount();

    boolean terminate = false;
    boolean finish = false;

    public void startGame() {
        //1. 게임 시작
        outputMessage.startMessage();
    }

    public void playGame() {

        //2. 게임 진행
        while (!terminate) {
            //2.1. 랜덤 숫자 생성
            List<Integer> computer = computerNumber.makeComputerNumber();
            //2.2. "숫자를 입력해주세요 :" 출력과 함께 사용자 입력
            while (!finish) {
                guessCount(computer);
            }
            //3. 게임 지속 여부 판단
            replayGame();
            //예외 처리 필요
        }
    }

    public void guessCount(List<Integer> computer) {
        inputMessage.requestNumberMessage();
        String answer = Console.readLine();
        validateNumber.Validator(answer);
        //2.4. 랜덤 숫자와 사용자 입력 숫자 값 비교
        int[] count;
        count = computeBallCount.ballCount(computer, answer);
        //2.4.1
        inputMessage.callBallCount(count);
        //2.4.2
        if (checkBallCount.strikeOut(count)){
            finish = true;
        }
    }

    public void replayGame() {
        outputMessage.replayMessage();
        String endNumber = Console.readLine();
        validateNumber.isEndNumber(endNumber);
        if (endNumber.equals("2")) {
            terminate = true;
        } else finish = false;
    }
}
