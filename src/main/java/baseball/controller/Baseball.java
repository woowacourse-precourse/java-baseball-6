package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.util.ComputeBallCount;
import baseball.util.ValidateNumber;
import baseball.view.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    PrintMessage printMessage = new PrintMessage();
    ValidateNumber validateNumber = new ValidateNumber();
    ComputerNumber computerNumber = new ComputerNumber();
    ComputeBallCount computeBallCount = new ComputeBallCount();

    boolean terminate = false;
    boolean game = false;

    public void startGame() {
        //1. 게임 시작
        printMessage.startMessage();
    }

    public void playGame() {

        //2. 게임 진행
        while (!terminate) {
            //2.1. 랜덤 숫자 생성
            List<Integer> computer = computerNumber.makeComputerNumber();
            //2.2. "숫자를 입력해주세요 :" 출력과 함께 사용자 입력
            while (!game) {
                guessCount(computer);
            }
            //3. 게임 지속 여부 판단
            replayGame();
            //예외 처리 필요
        }
    }

    public void guessCount(List<Integer> computer) {
        printMessage.inputMessage();
        String answer = Console.readLine();
        validateNumber.Validator(answer);
        //2.4. 랜덤 숫자와 사용자 입력 숫자 값 비교
        int[] count;
        count=computeBallCount.ballCount(computer, answer);
        int ball=count[0];
        int strike=count[1];
        //2.4.1
        String temp_string = "";
        if (ball == 0 && strike == 0) temp_string = "낫싱";
        if (ball != 0) temp_string += ball + "볼 ";
        if (strike != 0) temp_string += strike + "스트라이크";
        System.out.println(temp_string.trim());
        //2.4.2
        if (strike == 3) {
            printMessage.correctMessage();
            game = true;
        }
    }

    public void replayGame() {
        printMessage.replayMessage();
        String endNumber = Console.readLine();
        validateNumber.isEndNumber(endNumber);
        if (endNumber.equals("2")) {
            terminate = true;
        } else game = false;
    }


}
