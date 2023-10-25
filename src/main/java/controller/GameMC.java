package controller;

import model.BallCounter;
import model.GameNumberGenerator;
import model.InputValidator;
import view.*;

import java.util.List;

public class GameMC {

    /**
     * 게임을 진행하는 GameMC라는 가상의 진행자 기능을 구현
     * 전체적인 게임 로직 구현
     */
    public void gameStart() {
        int coin = 1;
        while(coin == 1) {
            StartTextPrinter startTextPrinter = new StartTextPrinter();
            startTextPrinter.printStartText(); //게임 시작을 알리는 텍스트 출력

            GameNumberGenerator gameNumberGenerator = new GameNumberGenerator();
            List<Integer> comNum = gameNumberGenerator.createNum(); //컴퓨터가 3개의 숫자를 생성
            UserGameNumberInput userGameNumberInput = new UserGameNumberInput();
            InputValidator inputValidator = new InputValidator();

            BallCounter ballCounter = new BallCounter();
            BallCountPrinter ballCountPrinter = new BallCountPrinter();
            InputTextPrinter inputTextPrinter = new InputTextPrinter();

            int[] result = new int[2]; // 사용자의 숫자를 보고 판단한 결과를 저장할 배열
            while (result[0] != 3) { // 3스트라이크면 while문을 빠져나옴
                inputTextPrinter.inputNum(); // 사용자의 입력을 요구하는 텍스트 출력
                List<Integer> userNum = userGameNumberInput.inputNum(); // 사용자의 입력을 받음
                inputValidator.validateUserInputNum(userNum); // 사용자 입력이 올바른지에 대한 검증

                result = ballCounter.ballCount(userNum, comNum); // ball count 결과 저장
                ballCountPrinter.printBallCount(result); // 결과 출력

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            RestartOrEndAcceptor acceptor = new RestartOrEndAcceptor();
            inputTextPrinter.coinNum(); // 게임을 재시작할지 종료할지 물어보는 텍스트 출력
            coin = acceptor.inputCoin(); // 게임 재시작/종료 입력
            inputValidator.validateUserInputCoin(coin); // 사용자 입력이 올바른지에 대한 검증
        }
        System.out.println("게임 종료");
    }
}
