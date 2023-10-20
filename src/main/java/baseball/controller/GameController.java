package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.GameStatus;
import baseball.domain.Player;
import baseball.domain.RandomComputerThreeNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final RandomComputerThreeNumbersGenerator randomComputerThreeNumbersGenerator;

    public GameController(OutputView outputView, InputView inputView,
                          RandomComputerThreeNumbersGenerator randomComputerThreeNumbersGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomComputerThreeNumbersGenerator = randomComputerThreeNumbersGenerator;
    }

    public void start() {
        // 1. 게임 시작 메시지 출력 ✅
        outputView.printGameStartMessage();
        // 2. 컴퓨터의 서로 다른 3자리 숫자 생성 ✅
        List<Integer> computer = randomComputerThreeNumbersGenerator.createOtherThreeNumbers();
        System.out.println(computer.toString());
        // 3. 3자리의 숫자를 모두 맞힐 때까지 반복 ✅
        GameStatus isPlaying = GameStatus.ONGOING;
        while (isPlaying.to()) {
            // 4. 플레이어가 입력한 서로 다른 3자리의 숫자 받아오기
            //Player player = getPlayerNumbers();
            Player player = inputView.inputThreeNumbers();
            // 5. 입력한 숫자 비교 후, 결과 생성 ✅
            GameResult gameResult = player.gameStartAndReturnResult(computer);
            // 6. 결과 출력
            outputView.printGameResult(gameResult);
            // 7. 모두 맞히면, isPlaying = GameStatus.SUCCESS.to();를 하고 게임 종료
            if (gameResult.getGameStatus() == GameStatus.SUCCESS) {
                isPlaying = GameStatus.SUCCESS;
            }
        }
        // 8. 게임 종료 메시지 출력 및 게임 재실행/종료에 대해 입력
        boolean gameAction = inputView.inputGameAction();
        // 9. 재실행인 경우, start() 호출(재귀 호출)
        if (gameAction) {
            start();
        }
        // 10. 종료인 경우, 게임 끝!
    }
}
