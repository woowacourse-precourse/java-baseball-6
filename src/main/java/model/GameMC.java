package model;

import controller.InputGameNumber;
import controller.InputReOrEnd;
import view.InputText;
import view.OutputBallCount;
import view.StartText;

import java.util.List;

public class GameMC {

    /**
     * 게임을 진행하는 GameMC라는 가상의 진행자 기능을 구현
     * 전체적인 게임 로직 구현
     */
    public void gameStart() {
        int coin = 1;
        while(coin == 1) {
            StartText startText = new StartText();
            startText.printStartText(); //게임 시작을 알리는 텍스트 출력

            CreateGameNumber createGameNumber = new CreateGameNumber();
            List<Integer> comNum = createGameNumber.createNum(); //컴퓨터가 3개의 숫자를 생성
            InputGameNumber inputGameNumber = new InputGameNumber();
            InputValidation inputValidation = new InputValidation();

            BallCounter ballCounter = new BallCounter();
            OutputBallCount outputBallCount = new OutputBallCount();
            InputText inputText = new InputText();

            int[] result = new int[2]; // 사용자의 숫자를 보고 판단한 결과를 저장할 배열
            while (result[0] != 3) { // 3스트라이크면 while문을 빠져나옴
                inputText.inputNum(); // 사용자의 입력을 요구하는 텍스트 출력
                List<Integer> userNum = inputGameNumber.inputNum(); // 사용자의 입력을 받음
                inputValidation.gameNumValidation(userNum); // 사용자 입력이 올바른지에 대한 검증

                result = ballCounter.ballCount(userNum, comNum); // ball count 결과 저장
                outputBallCount.printCount(result); // 결과 출력
            }

            InputReOrEnd inputReOrEnd = new InputReOrEnd();
            inputText.coinNum(); // 게임을 재시작할지 종료할지 물어보는 텍스트 출력
            coin = inputReOrEnd.inputCoin(); // 게임 재시작/종료 입력
            inputValidation.coinValidation(coin); // 사용자 입력이 올바른지에 대한 검증
        }
    }
}
