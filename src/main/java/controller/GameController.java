package controller;

import static util.StringToArrayList.StringToArrayList;

import java.util.ArrayList;
import java.util.List;
import model.Computer;
import service.GameFlowManagementService;
import service.GameNumberCheckService;
import util.ValidationCheck;
import view.GameScoreView;
import view.GameView;

public class GameController {

    private static final int STRIKE_COUNT_INDEX = 0; // 현재 스트라이크 개수 -> 인덱스로 저장
    private static final int STRIKE_COUNT_THREE = 3; // 현재의 스트라이크 개수와 비교하기 위한 3스트라이크의 값 생성

    private Computer computer = new Computer();

    private final GameView gameView = new GameView();
    private final ValidationCheck validationCheck = new ValidationCheck();
    private final GameNumberCheckService gameNumberCheckService = new GameNumberCheckService();
    private final GameScoreView gameScoreView = new GameScoreView();
    private final GameFlowManagementService gameFlowManagementService = new GameFlowManagementService();

    private List<Integer> countStrikeBall = new ArrayList<>();

    public void startGame() {
        // 1. 게임 시작 메시지
        gameView.startGameView();

        // 2. 컴퓨터 숫자 입력
        computer.setComputerNumbers();

        while (!gameFlowManagementService.gameQuit()) { // 8. 반복여부 조건문 추가

            // 3. 사용자 숫자 입력
            String userInput = gameView.userInput();

            // 4. 사용자 숫자 유효성 체크
            validationCheck.checkUserInput(userInput);

            // 5. 사용자 입력 값 List로 변환
            List<Integer> userNumbers = StringToArrayList(userInput);

            // 6. 플레이어의 숫자와 컴퓨터의 숫자를 비교해 스트라이크와 볼을 계산
            countStrikeBall = gameNumberCheckService.compareGameNumber(userNumbers,
                    computer.getComputerNumbers());

            // 7. 3 스트라이크 발생시 게임 종료. 재시작 여부 확인
            if (countStrikeBall.get(STRIKE_COUNT_INDEX) == STRIKE_COUNT_THREE) {
                gameScoreView.completeThreeStrikeScore();
                gameFlowManagementService.nextGameFlow(computer);
            } else {
                gameScoreView.incompleteThreeStrikeScore(countStrikeBall); // 3 스트라이크 아닐 때
            }
        }
    }
}
