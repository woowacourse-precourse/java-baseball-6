package baseball.controller;

import baseball.domain.GameResultDTO;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final GameService gameService = new GameService();
    GameResultDTO gameResultDTO;

    // 최초 한 번 게임 시작 메시지 출력
    public BaseballGameController() {
        GameStartMessage();
    }

    // 게임 진행
    private void playGame() {
        InputNumberMessage(); // 숫자 입력 메시지 출력
        List<Integer> playerNumber = inputView.PlayerNumberInput();
        gameResultDTO = gameService.GameResult(playerNumber);
        GameResultMessage(); // 게임 결과 메시지 출력
        IsFinishGame(); // 게임 승/패 판정
    }

    public void run() {
        GenerateComputerNumber(); // 컴퓨터 랜덤 수 생성
        playGame(); // 게임 진행
        EndOrRestart(); // 게임 재시작/종료 여부 판단
    }

    // 숫자 입력 메시지 출력
    private void InputNumberMessage() {
        outputView.InputNumber();
    }

    // 게임 결과 메시지 출력
    private void GameResultMessage() {
        outputView.GameResult(gameResultDTO);
    }

    // 게임 시작 메시지 출력
    private void GameStartMessage() {
        outputView.StartGame();
    }

    // 컴퓨터 랜덤 수 생성
    private void GenerateComputerNumber() {
        gameService.setComputerNumber();
    }

    // 사용자가 컴퓨터 수를 맞췄는지 판정
    private void IsFinishGame() {
        if(gameResultDTO.getStrike() == 3) {
            outputView.EndGame();
        }
        else {
            playGame();
        }
    }

    // 게임 재시작/종료 여부 판단
    private void EndOrRestart() {
        int inputNum = inputView.FinishGame();
        if(inputNum == 1) {
            run();
        }
        else {
            System.out.println("종료!");
        }
    }
}
