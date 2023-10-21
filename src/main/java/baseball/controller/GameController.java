package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameResultGenerator;
import baseball.model.PlayerChoice;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private boolean continueGame = true;  //게임(다음 라운드) 계속 진행 여부 (3스트라이크가 아닌 경우) (3스트라이크 이면 false)
    private boolean wantRestart = true;  //재시작 여부

    private static GameController gameController = new GameController();

    private GameController() {
    }

    public static GameController getInstance() {
        return gameController;
    }


    public void run() {
        ComputerNumber computerNumber = createComputerNumber();  //컴퓨터넘버 생성

        //3스트라이크 나올 때까지 게임 계속 진행
        while (continueGame) {
            play(computerNumber);
        }
        doRestart();  //3스트라이크 인 경우, 게임 재시작 or 종료 여부 체크
    }

    /**
     * ComputerNumber 생성
     */
    private ComputerNumber createComputerNumber() {
        return ComputerNumber.createComputerNumber();
    }


    private void play(ComputerNumber computerNumber) {
        OutputView.printGetInput();  //사용자로부터 값 입력 받는 문구 출력
        String input = InputView.readInput();  //사용자로부터 값을 입력 받기
        PlayerNumber playerNumber = PlayerNumber.createPlayerNumber(input);  //PlayerNumber 객체 생성

        //게임 결과 계산
        GameResultGenerator gameResultGenerator = new GameResultGenerator(computerNumber, playerNumber);

        //게임 결과 출력
        OutputView.printResult(gameResultGenerator.isNothing(), gameResultGenerator.getBallCount(), gameResultGenerator.getStrikeCount());

        //게임(다음 라운드) 진행 여부를 변수에 재할당
        continueGame = !gameResultGenerator.isThreeStrike();
    }

    /**
     * 게임 종료 시 재시작 or 종료 판단
     */
    private void doRestart() {
        OutputView.printEnd();
        String input = InputView.readInput();
        PlayerChoice playerChoice = new PlayerChoice(input);
        wantRestart = (playerChoice.getValue() == 1);
        continueGame = true;
    }

    public boolean isWantRestart() {
        return wantRestart;
    }
}
