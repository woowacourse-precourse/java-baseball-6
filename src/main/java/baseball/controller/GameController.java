package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GameResultDTO;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final GameService gameService = new GameService();
    private GameResultDTO gameResultDTO;

    // 최초 한 번 게임 시작 메시지 출력
    public GameController() {
        gameStartMessage();
    }

    // 게임 진행
    private void playGame() {
        inputNumberMessage(); // 숫자 입력 메시지 출력
        GameNumber playerNumbers = inputView.playerNumberInput();
        gameResultDTO = gameService.calculateGameResult(playerNumbers);
        gameResultMessage(); // 게임 결과 메시지 출력
        isGameFinished(); // 게임 승/패 판정
    }

    public void run() {
        generateComputerNumber(); // 컴퓨터 랜덤 수 생성
        playGame(); // 게임 진행
        restartOrExit(); // 게임 재시작/종료 여부 판단
    }

    // 숫자 입력 메시지 출력
    private void inputNumberMessage() {
        outputView.inputNumber();
    }

    // 게임 결과 메시지 출력
    private void gameResultMessage() {
        outputView.displayGameResult(gameResultDTO);
    }

    // 게임 시작 메시지 출력
    private void gameStartMessage() {
        outputView.startGame();
    }

    // 컴퓨터 랜덤 수 생성
    private void generateComputerNumber() {
        gameService.setComputerNumber();
    }

    // 게임이 끝나는지 확인
    private void isGameFinished() {
        if (!gameResultDTO.getIsGameFinished()) {
            playGame();
            return;
        }
        outputView.displayEndGameMessage();
    }

    // 게임 재시작/종료 여부 판단
    private void restartOrExit() {
        GameNumber inputNum = inputView.endOrRestartInput();
        if (inputNum.getNumber().get(0) == 1) {
            run();
        }
    }
}
