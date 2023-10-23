package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.util.CompareNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    private ComputerNumber computerNumber;
    private PlayerNumber playerNumber;
    private CompareNumber compareNumber;

    public BaseballGame(){
        computerNumber = new ComputerNumber();
        playerNumber = new PlayerNumber();
        compareNumber = new CompareNumber();
    }

    public void startGame() {
        OutputView.gameStartMessage();

        while (true) {
            //컴퓨터 난수 생성
            computerNumber.generateRandomNumber();

            //플레이어로부터 숫자 입력 받기
            String playerInput = InputView.setPlayerNumber();
            playerNumber.setPlayerNumber(playerInput);

            //숫자 비교 및 결과 출력
            List<Integer> playerNumbers = playerNumber.getPlayerNumber();
            List<Integer> computerNumbers = computerNumber.getComputerNumber();
            compareNumber.countStrikeAndBall(computerNumbers, playerNumbers);

            int ball = compareNumber.getBallCount();
            int strike = compareNumber.getStrikeCount();

            OutputView.printBallAndStrike(ball, strike);

            //게임 종료 조건
            if (strike == 3) {
                OutputView.gameOverMessage();
                break;
            }
        }

        //게임 재시작 여부 확인
        int gameRestart = Integer.parseInt(InputView.setRetryGame());
        if (gameRestart == 1) {
            computerNumber.resetGame();
            startGame();
        }
    }
    public static void main(String[] args){
        BaseballGame game = new BaseballGame();
        game.startGame();
    }
}
